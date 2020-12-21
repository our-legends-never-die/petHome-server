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
}