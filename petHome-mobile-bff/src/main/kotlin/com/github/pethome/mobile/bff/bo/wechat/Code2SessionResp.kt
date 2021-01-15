package com.github.pethome.mobile.bff.bo.wechat

/**
 * @author Chimm Huang
 */
class Code2SessionResp : WechatBaseResp {

    /** 用户唯一标识 */
    var openid: String? = null

    /** 会话密钥 */
    var session_key: String? = null

    /** 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回 */
    var unionid: String? = null

    constructor(
        errcode: Int?,
        errmsg: String?,
        openid: String?,
        session_key: String?,
        unionid: String?
    ) : super(errcode, errmsg) {
        this.openid = openid
        this.session_key = session_key
        this.unionid = unionid
    }

    constructor() : super()


}