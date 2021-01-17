package com.github.pethome.api.dto.user

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

/**
 * @author Chimm Huang
 */
class WechatLoginReq(
    @ApiModelProperty(value = "通过 wx.login 接口获得临时登录凭证 code", required = true)
    @field:NotBlank var code: String
)


