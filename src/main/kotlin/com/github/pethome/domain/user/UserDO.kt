package com.github.pethome.domain.user

import com.github.pethome.domain.BaseDomain
import java.time.LocalDateTime
import javax.persistence.Table

/**
 * @author Chimm Huang
 */
@Table(name = "user")
class UserDO : BaseDomain {
    var userId: String? = null
    var wechatOpenId: String? = null
    var phoneNo: String? = null
    var nickname: String? = null

    constructor(id: Long?, gmtCreate: LocalDateTime?, creatorId: Long?, gmtModified: LocalDateTime?, modifierId: Long?, delFlag: Boolean?, userId: String?, wechatOpenId: String?, phoneNo: String?, nickname: String?) : super(id, gmtCreate, creatorId, gmtModified, modifierId, delFlag) {
        this.userId = userId
        this.wechatOpenId = wechatOpenId
        this.phoneNo = phoneNo
        this.nickname = nickname
    }

    constructor() : super()
}