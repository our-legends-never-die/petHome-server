package com.github.pethome.api.util

import com.github.pethome.api.enums.PlatformEnum
import com.github.pethome.common.util.ConfigUtil
import org.slf4j.LoggerFactory


/**
 * @author Chimm Huang
 */
object RestTemplateUtil {

    private val log = LoggerFactory.getLogger(RestTemplateUtil::class.java)


    /**
     * 获取完整的 url 地址
     *
     * @param platformEnum 调用平台枚举
     * @param uri api接口地址
     * @return 完成的 url 地址
     */
    fun getPlatformUrl(platformEnum: PlatformEnum?, uri: String): String {
        if (platformEnum?.urlConfigName == null) {
            return uri
        }

        val platformUrl = ConfigUtil.getPropByName(platformEnum.urlConfigName, "")

        return platformUrl + uri
    }
}