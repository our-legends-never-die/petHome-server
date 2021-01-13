package com.github.pethome.provider.domain.common

import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.provider.common.BaseDomain

import org.apache.ibatis.type.JdbcType
import tk.mybatis.mapper.annotation.ColumnType
import java.time.LocalDateTime
import javax.persistence.Table

/**
 * @author Chimm Huang
 */
@Table(name = "pet2other_link")
class Pet2OtherLinkDO : BaseDomain {

    var linkName: String? = null
    var url: String? = null
    var interfaceDocUrl: String? = null
    @ColumnType(jdbcType = JdbcType.VARCHAR)
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

    constructor(
        linkName: String?,
        url: String?,
        interfaceDocUrl: String?,
        platform: PlatformEnum?,
        memo: String?
    ) : super() {
        this.linkName = linkName
        this.url = url
        this.interfaceDocUrl = interfaceDocUrl
        this.platform = platform
        this.memo = memo
    }
}