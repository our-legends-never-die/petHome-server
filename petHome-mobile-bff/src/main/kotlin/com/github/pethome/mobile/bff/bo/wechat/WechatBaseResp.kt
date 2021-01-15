package com.github.pethome.mobile.bff.bo.wechat

/**
 * @author Chimm Huang
 */
open class WechatBaseResp {

    /** 错误码 */
    var errcode: Int? = null

    /** 错误信息 */
    var errmsg: String? = null

    constructor()
    constructor(errcode: Int?, errmsg: String?) {
        this.errcode = errcode
        this.errmsg = errmsg
    }

}