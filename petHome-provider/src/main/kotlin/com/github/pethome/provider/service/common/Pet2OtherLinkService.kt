package com.github.pethome.provider.service.common

import com.github.pethome.api.dto.common.Pet2OtherLinkDTO
import com.github.pethome.api.enums.PlatformEnum

/**
 * @author Chimm Huang
 */
interface Pet2OtherLinkService {

    /**
     * 查询外部链接信息
     *
     * @param linkName 链接名称
     * @param platformEnum 平台枚举
     */
    fun selectByLinkNameAndPlatform(linkName: String, platformEnum: PlatformEnum): Pet2OtherLinkDTO
}