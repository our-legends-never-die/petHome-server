package com.github.pethome.mobile.bff.controller.wechat

import com.github.pethome.api.dto.user.UserDTO
import com.github.pethome.api.dto.user.WechatLoginReq
import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.api.resource.common.Pet2OtherLinkResource
import com.github.pethome.api.resource.user.UserResource
import com.github.pethome.api.util.RestTemplateUtil
import com.github.pethome.common.constant.UserLoginConstant.TOKEN_PREFIX
import com.github.pethome.common.constant.UserLoginConstant.USER_SESSION_KEY_PREFIX
import com.github.pethome.common.constant.UserLoginConstant.USER_TOKEN_PREFIX
import com.github.pethome.common.enums.DeleteFlagEnum
import com.github.pethome.common.exception.WechatException
import com.github.pethome.common.util.ConfigUtil
import com.github.pethome.mobile.bff.bo.wechat.Code2SessionResp
import com.github.pethome.mobile.bff.vo.wechat.LoginResp
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import java.util.*
import java.util.concurrent.*
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.validation.Valid
import kotlin.collections.HashMap

/**
 * @author Chimm Huang
 */
@RestController
@Api(tags = ["微信公众平台"])
@RequestMapping(value = ["/wechat"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
open class WechatController(
    private val pet2OtherLinkResource: Pet2OtherLinkResource,
    private val restTemplate: RestTemplate,
    private val userResource: UserResource,
    private val redisTemplate: RedisTemplate<String, String>
) {

    /**
     * 微信登录 -- 获取用户 openId
     *
     * @param code 小程序登录时获取的 code
     */
    @ApiOperation("微信登录")
    @PostMapping("/login")
    fun login(@RequestBody @Valid wechatLoginReq: WechatLoginReq): LoginResp {

        val pet2OtherLinkDTO = pet2OtherLinkResource.selectByLinkNameAndPlatform("code2Session", PlatformEnum.WECHAT)
        val url = RestTemplateUtil.getPlatformUrl(PlatformEnum.WECHAT, pet2OtherLinkDTO.url!!)

        // 组装参数
        val params = HashMap<String, String>()
        params.put("APPID", ConfigUtil.getPropByName("petHome.wechat.appId", "")!!)
        params.put("SECRET", ConfigUtil.getPropByName("petHome.wechat.appSecret", "")!!)
        params.put("JSCODE", wechatLoginReq.code)

        // https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
        val resp = restTemplate.getForEntity(url, Code2SessionResp::class.java, params).body

        if (resp.errcode == -1) {
            throw WechatException("系统繁忙")
        } else if (resp.errcode == 40029) {
            throw WechatException("code 无效")
        }

        // 定义返回值
        val loginResp = LoginResp()

        // 查询数据库是否存在，若不存在，则进行注册
        var userDTO = userResource.selectByWechatOpenId(resp.openid!!)
        if (userDTO == null) {
            // 注册用户
            userDTO = userResource.insertSelective(UserDTO().apply {
                userId = UUID.randomUUID().toString().replace("-", "")
                wechatOpenId = resp.openid
                delFlag = DeleteFlagEnum.NORMAL.delFlag
            })
            loginResp.newUserFlag = true
        }

        // 生成新的 token
        val token = UUID.randomUUID().toString().replace("-", "")

        // 设置 token 过期时间
        val time = ConfigUtil.getPropByName("petHome.login.timeout", "30")!!.toLong()
        val timeUnit = ConfigUtil.getPropByName("petHome.login.timeUnit", "DAYS")!!

        // 设置登陆 token
        redisTemplate.opsForValue().set("$TOKEN_PREFIX$token", userDTO.userId, time, TimeUnit.valueOf(timeUnit))
        // 设置该用户最新的 token （将别处已登陆的挤下去）
        redisTemplate.opsForValue().set("$USER_TOKEN_PREFIX${userDTO.userId}", token)
        // 设置该用户最新的 sessionKey
        redisTemplate.opsForValue().set("$USER_SESSION_KEY_PREFIX${userDTO.userId}", resp.session_key)

        return loginResp
    }

    @GetMapping("/demo")
    fun demo(): String {
        val pet2OtherLinkDTO = pet2OtherLinkResource.selectByLinkNameAndPlatform("code2Session", PlatformEnum.WECHAT)
        val url = RestTemplateUtil.getPlatformUrl(PlatformEnum.WECHAT, pet2OtherLinkDTO.url!!)

        return url
    }
}