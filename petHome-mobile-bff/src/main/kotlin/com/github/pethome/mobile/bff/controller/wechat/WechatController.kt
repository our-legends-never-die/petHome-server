package com.github.pethome.mobile.bff.controller.wechat

import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.api.resource.common.Pet2OtherLinkResource
import com.github.pethome.api.util.RestTemplateUtil
import com.github.pethome.mobile.bff.util.RespUtil
import io.swagger.annotations.Api
import java.lang.RuntimeException
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.validation.constraints.NotEmpty

/**
 * @author Chimm Huang
 */
@Validated
@RestController
@Api(tags = ["微信公众平台"])
@RequestMapping(value = ["/wechat"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
open class WechatController(
    open val pet2OtherLinkResource: Pet2OtherLinkResource,
    open val restTemplate: RestTemplate
) {

    /**
     * 获取用户 openId
     *
     * @param code 小程序登录时获取的 code
     */
    fun code2Session(@NotEmpty code: String): String {
        val pet2OtherLinkDTO = pet2OtherLinkResource.selectByLinkNameAndPlatform("code2Session", PlatformEnum.WECHAT)
        val url = RestTemplateUtil.getPlatformUrl(PlatformEnum.WECHAT, pet2OtherLinkDTO.url!!)

        val body = restTemplate.getForEntity(url, String::class.java, null)


        return RespUtil.respSuccess()

    }

    @GetMapping("/demo")
    fun demo(): String {
        val pet2OtherLinkDTO = pet2OtherLinkResource.selectByLinkNameAndPlatform("code2Session", PlatformEnum.WECHAT)
        val url = RestTemplateUtil.getPlatformUrl(PlatformEnum.WECHAT, pet2OtherLinkDTO.url!!)

        throw RuntimeException("哈哈哈")
    }
}