package com.github.pethome.provider.service.impl.common

import com.github.pethome.api.dto.common.Pet2OtherLinkDTO
import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.common.exception.ServerException
import com.github.pethome.provider.repository.impl.common.Pet2OtherLinkRepository
import com.github.pethome.provider.service.common.Pet2OtherLinkService
import org.springframework.stereotype.Service

/**
 * @author Chimm Huang
 */
@Service
class Pet2OtherLinkServiceImpl(
    private val pet2OtherLinkRepository: Pet2OtherLinkRepository
) : Pet2OtherLinkService {

    override fun selectByLinkNameAndPlatform(linkName: String, platformEnum: PlatformEnum): Pet2OtherLinkDTO {
        val pet2OtherLinkDTO = pet2OtherLinkRepository.selectOne(Pet2OtherLinkDTO().apply {
            this.linkName = linkName
            this.platform = platformEnum
        })

        return pet2OtherLinkDTO ?: throw ServerException("未查询到外部链接信息")
    }

}