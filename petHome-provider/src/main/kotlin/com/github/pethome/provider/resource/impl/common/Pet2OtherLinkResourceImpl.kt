package com.github.pethome.provider.resource.impl.common

import com.github.pethome.api.dto.common.Pet2OtherLinkDTO
import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.api.resource.common.Pet2OtherLinkResource
import com.github.pethome.provider.service.common.Pet2OtherLinkService
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chimm Huang
 */
@RestController
open class Pet2OtherLinkResourceImpl(
    private val pet2OtherLinkService: Pet2OtherLinkService
) : Pet2OtherLinkResource {

    override fun selectByLinkNameAndPlatform(linkName: String, platformEnum: PlatformEnum): Pet2OtherLinkDTO {
        return pet2OtherLinkService.selectByLinkNameAndPlatform(linkName, platformEnum)
    }

}