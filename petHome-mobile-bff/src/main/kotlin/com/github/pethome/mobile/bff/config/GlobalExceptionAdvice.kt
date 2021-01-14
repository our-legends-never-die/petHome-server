package com.github.pethome.mobile.bff.config

import com.github.pethome.mobile.bff.util.RespEnum
import com.github.pethome.mobile.bff.util.RespUtil
import java.lang.Exception
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 全局异常处理
 *
 * @author Chimm Huang
 */
@RestControllerAdvice
class GlobalExceptionAdvice {

    @ExceptionHandler(value = [Exception::class])
    fun exceptionHandler(e: Exception): String? {
        println("未知异常！原因是:$e")
        return RespUtil.resp(RespEnum.COMMON_ERROR.message("错误"))
    }
}