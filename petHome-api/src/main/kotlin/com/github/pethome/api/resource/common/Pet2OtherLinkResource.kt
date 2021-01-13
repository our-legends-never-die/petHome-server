package com.github.pethome.api.resource.common

import com.github.pethome.api.dto.common.Pet2OtherLinkDTO
import com.github.pethome.common.constant.ApiConstant.PROVIDER_URL_PREFIX_PET_TO_OTHER_LINK
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author Chimm Huang
 */
@FeignClient(value = "\${petHome.providerName}")
interface Pet2OtherLinkResource {


    /**
     * 查询外部链接信息
     *
     * @param linkName 链接名称
     * @param platformEnum 平台枚举
     */
    @RequestMapping("$PROVIDER_URL_PREFIX_PET_TO_OTHER_LINK/selectByLinkNameAndPlatform")
    fun selectByLinkNameAndPlatform(
        @RequestParam("linkName") linkName: String,
        @RequestParam("platformEnum") platformEnum: com.github.pethome.api.enums.PlatformEnum
    ): Pet2OtherLinkDTO


}