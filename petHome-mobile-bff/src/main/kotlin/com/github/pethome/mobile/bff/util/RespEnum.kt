package com.github.pethome.mobile.bff.util

/**
 * @author Chimm Huang
 */
enum class RespEnum(var code: String, var message: String) {

    /**
     * 请求成功
     */
    SUCCESS("0","请求成功"),

    /**
     * 系统异常，主要针对500错误，开发者禁止使用此类型
     */
    SYSTEM_ERROR("10000", "系统异常"),

    /**
     * 已经退出
     */
    HAS_LOGOUT("10001","已经退出，需要重新登录"),

    /**
     * 自定义异常，对于系统中业务异常统一使用此类
     */
    COMMON_ERROR("20000","")
    ;

    fun message(message: String): RespEnum {
        this.message = message
        return this
    }

    fun code(code: String): RespEnum {
        this.code = code
        return this
    }

}