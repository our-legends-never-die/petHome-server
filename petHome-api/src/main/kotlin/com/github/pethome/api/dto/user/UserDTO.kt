package com.github.pethome.api.dto.user

import com.github.pethome.api.dto.BaseDTO
import java.time.LocalDateTime

/**
 * @author Chimm Huang
 */
class UserDTO : BaseDTO {
    var userId: String? = null
    var wechatOpenId: String? = null
    var phoneNo: String? = null
    var nickname: String? = null

    constructor(id: Long?, gmtCreate: LocalDateTime?, creatorId: Long?, gmtModified: LocalDateTime?, modifierId: Long?, delFlag: Int?, userId: String?, wechatOpenId: String?, phoneNo: String?, nickname: String?) : super(id, gmtCreate, creatorId, gmtModified, modifierId, delFlag) {
        this.userId = userId
        this.wechatOpenId = wechatOpenId
        this.phoneNo = phoneNo
        this.nickname = nickname
    }

    constructor() : super()


}