package com.github.pethome.provider.config

import com.github.pethome.common.exception.PetException
import com.github.pethome.common.exception.UnknownException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 捕获 provider 的所有异常，并且包装之后扔给调用方
 *
 * @author Chimm Huang
 */
@RestControllerAdvice
class ProviderControllerAdvice {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ProviderControllerAdvice::class.java)
    }

    @ExceptionHandler(Exception::class)
    fun exception(e: Exception): String? {
        val msg = e.message
        log.error("异常{$msg}, {}", e)

        if (e is PetException) {
            throw e
        }

        // 其他异常
        throw UnknownException(e.message, e)
    }
}