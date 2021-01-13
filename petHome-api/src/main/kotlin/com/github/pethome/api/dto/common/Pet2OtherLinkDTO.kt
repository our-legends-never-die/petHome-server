package com.github.pethome.api.dto.common

import com.github.pethome.api.dto.BaseDTO
import com.github.pethome.api.enums.PlatformEnum
import java.time.LocalDateTime

/**
 * @author Chimm Huang
 */
class Pet2OtherLinkDTO : BaseDTO {

    var linkName: String? = null
    var url: String? = null
    var interfaceDocUrl: String? = null
    var platform: PlatformEnum? = null
    var memo: String? = null


    constructor(
        id: Long?,
        gmtCreate: LocalDateTime?,
        creatorId: Long?,
        gmtModified: LocalDateTime?,
        modifierId: Long?,
        delFlag: Boolean?,
        linkName: String?,
        url: String?,
        interfaceDocUrl: String?,
        platform: PlatformEnum?,
        memo: String?
    ) : super(id, gmtCreate, creatorId, gmtModified, modifierId, delFlag) {
        this.linkName = linkName
        this.url = url
        this.interfaceDocUrl = interfaceDocUrl
        this.platform = platform
        this.memo = memo
    }

    constructor() : super()


}
