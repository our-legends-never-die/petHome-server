package com.github.pethome.provider.common

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author Chimm Huang
 */
open class BaseDomain {

    constructor(id: Long?, gmtCreate: LocalDateTime?, creatorId: Long?, gmtModified: LocalDateTime?, modifierId: Long?, delFlag: Int?) {
        this.id = id
        this.gmtCreate = gmtCreate
        this.creatorId = creatorId
        this.gmtModified = gmtModified
        this.modifierId = modifierId
        this.delFlag = delFlag
    }

    constructor()

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var gmtCreate: LocalDateTime? = null
    var creatorId: Long? = null
    var gmtModified: LocalDateTime? = null
    var modifierId: Long? = null
    var delFlag: Int? = null
}