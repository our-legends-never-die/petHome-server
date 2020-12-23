package com.github.pethome.dto

import java.time.LocalDateTime

/**
 * @author Chimm Huang
 */
open class BaseDTO {
    var id: Long? = null
    var gmtCreate: LocalDateTime? = null
    var creatorId: Long? = null
    var gmtModified: LocalDateTime? = null
    var modifierId: Long? = null
    var delFlag: Boolean? = null

    constructor(id: Long?, gmtCreate: LocalDateTime?, creatorId: Long?, gmtModified: LocalDateTime?, modifierId: Long?, delFlag: Boolean?) {
        this.id = id
        this.gmtCreate = gmtCreate
        this.creatorId = creatorId
        this.gmtModified = gmtModified
        this.modifierId = modifierId
        this.delFlag = delFlag
    }

    constructor()


}