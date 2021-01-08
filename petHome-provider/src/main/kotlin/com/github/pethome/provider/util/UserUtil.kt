package com.github.pethome.provider.util

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

/**
 * @author Chimm Huang
 */
object UserUtil {

    fun getUserId(): Long {
        // TODO: 2020/12/24
        return 1L
    }

    /**
     * 获取登录 token
     */
    fun getToken(): String {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        return request.getHeader("token")
    }


}