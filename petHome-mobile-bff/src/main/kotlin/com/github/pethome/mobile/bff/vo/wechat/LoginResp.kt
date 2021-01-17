package com.github.pethome.mobile.bff.vo.wechat

import io.swagger.annotations.ApiModelProperty

/**
 * @author Chimm Huang
 */
class LoginResp {

    @ApiModelProperty("是否为新用户？")
    var newUserFlag: Boolean = false
}