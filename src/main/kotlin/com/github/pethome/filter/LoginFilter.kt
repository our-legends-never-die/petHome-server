package com.github.pethome.filter

import com.github.pethome.common.constant.UserLoginConstant.TOKEN_NAME
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.MediaType
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author Chimm Huang
 */
@WebFilter
class LoginFilter : Filter {

    @Autowired
    private lateinit var redisTemplate: RedisTemplate<String, String>


    override fun doFilter(req: ServletRequest?, resp: ServletResponse?, chain: FilterChain) {
        val request = req as HttpServletRequest
        val response = resp as HttpServletResponse

        request.characterEncoding = "UTF-8"
        response.characterEncoding = "UTF-8"
        response.contentType = MediaType.APPLICATION_JSON_UTF8_VALUE // 解决response.getWriter().println中文乱码

        val uri = request.requestURI.toLowerCase()

        val token = request.getHeader(TOKEN_NAME)

    }
}