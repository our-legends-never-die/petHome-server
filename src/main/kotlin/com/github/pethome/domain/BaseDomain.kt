package com.github.pethome.domain

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author Chimm Huang
 */
open class BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var gmtCreate: LocalDateTime? = null
    var creatorId: Long? = null
    var gmtModified: LocalDateTime? = null
    var modifierId: Long? = null
    var delFlag: Boolean? = null
}