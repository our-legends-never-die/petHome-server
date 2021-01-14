package com.github.pethome.mobile.bff.config

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.pethome.mobile.bff.util.RespEnum
import com.github.pethome.mobile.bff.vo.BaseResp
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

/**
 * 统一返回值处理
 *
 * @author Chimm Huang
 */
@RestControllerAdvice(basePackages = ["com.github.pethome.mobile.bff.controller"])
class ControllerResponseAdvice : ResponseBodyAdvice<Any> {

    companion object {
        private val objectMapper = JsonMapper.builder().addModule(KotlinModule()).build()
    }

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        val resp = BaseResp(body, RespEnum.SUCCESS)
        return objectMapper.writeValueAsString(resp)
    }

}