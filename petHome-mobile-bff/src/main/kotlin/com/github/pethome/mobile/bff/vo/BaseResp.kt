package com.github.pethome.mobile.bff.vo

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.pethome.mobile.bff.util.RespEnum

/**
 * @author Chimm Huang
 */
@JsonPropertyOrder(value = ["code", "message", "data"])
class BaseResp {

    var code: String? = null
    var message: String? = null
    var data: Any? = null

    constructor(data: Any?, respEnum: RespEnum) {
        this.data = data
        this.code = respEnum.code
        this.message = respEnum.message
    }
}