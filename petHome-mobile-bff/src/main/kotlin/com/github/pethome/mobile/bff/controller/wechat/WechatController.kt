package com.github.pethome.mobile.bff.controller.wechat

import com.github.pethome.api.dto.user.WechatLoginReq
import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.api.resource.common.Pet2OtherLinkResource
import com.github.pethome.api.util.RestTemplateUtil
import com.github.pethome.common.exception.WechatException
import com.github.pethome.common.util.ConfigUtil
import com.github.pethome.mobile.bff.bo.wechat.Code2SessionResp
import io.swagger.annotations.Api
import java.lang.RuntimeException
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.validation.Valid

/**
 * @author Chimm Huang
 */
@RestController
@Api(tags = ["微信公众平台"])
@RequestMapping(value = ["/wechat"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
open class WechatController(
    open val pet2OtherLinkResource: Pet2OtherLinkResource,
    open val restTemplate: RestTemplate
) {

    /**
     * 微信登录 -- 获取用户 openId
     *
     * @param code 小程序登录时获取的 code
     */
    @PostMapping("/login")
    fun login(@RequestBody @Valid wechatLoginReq: WechatLoginReq): String {
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

        // todo 查询数据库是否存在，若不存在，则进行注册

        return "成功"

    }

    @GetMapping("/demo")
    fun demo(): String {
        val pet2OtherLinkDTO = pet2OtherLinkResource.selectByLinkNameAndPlatform("code2Session", PlatformEnum.WECHAT)
        val url = RestTemplateUtil.getPlatformUrl(PlatformEnum.WECHAT, pet2OtherLinkDTO.url!!)

        throw RuntimeException("哈哈哈")
    }
}