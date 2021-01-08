package com.github.pethome.mobile.bff.filter

import com.github.pethome.common.constant.UserLoginConstant.TOKEN_NAME
import com.github.pethome.common.constant.UserLoginConstant.TOKEN_PREFIX
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
        // 获取 token
        val token = request.getHeader(TOKEN_NAME)


        // 其他请求，需要验证token的有效性
        val redisTokenKey: String = TOKEN_PREFIX + token

//        redisTemplate.opsForValue().get("")
//
//        val userInfo = redisTemplate.opsForValue()[redisTokenKey]
//        if (StringUtils.isBlank(userInfo)) {
//            response.status = 401
//            response.writer.println(JSON.toJSONString(ErrorResponse(401, ResultCode.HAS_LOGOUT.getMessage())))
//            return
//        }
//
//        // 如果在别处也登录了，那么把您挤下去
//        val user: UserInfo = JSON.parseObject(userInfo, UserInfo::class.java)
//        val userTokenValue: String = USER_ID_PREFIX + user.getId()
//        val existToken = redisTemplate.opsForValue()[userTokenValue]
//        if (existToken != token) {
//            response.status = 401
//            response.writer.println(JSON.toJSONString(ErrorResponse(401, ResultCode.HAS_LOGOUT.message("您在别处登录了，请重新登录！").getMessage())))
//            return
//        }
//
//        // 刷新token
//        val time: String = ConfigUtil.getPropByName("login.timeout", "2")
//        val timeUnit: String = ConfigUtil.getPropByName("login.timeout.timeUnit", "HOURS")
//        val timeout = time.toLong()
//        redisTemplate.opsForValue()[redisTokenKey, userInfo, timeout] = TimeUnit.valueOf(timeUnit)
//
//        setHeaderUserInfo(request, userInfo, token, user)
        chain.doFilter(request, response)

    }
}