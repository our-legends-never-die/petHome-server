package com.github.pethome.mobile.bff.util

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.Serializable

/**
 * @author Chimm Huang
 */
@JsonPropertyOrder(value = ["code", "message", "data"])
class RespUtil {

    private var code: String? = null
    private var message: String? = null
    private var data: Any? = null

    constructor(data: Any?, respEnum: RespEnum) {
        this.data = data
        this.code = respEnum.code
        this.message = respEnum.message
    }

    companion object {

        private val objectMapper = ObjectMapper()

        /**
         * 请求成功：无返回值
         *
         * <pre>
         * {
         * "code": "0",
         * "desc": "请求成功",
         * "data": `null`
         * }
        </pre> *
         *
         * @return 返回成功
         */
        fun respSuccess(): String {
            return resp(RespEnum.SUCCESS)
        }

        /**
         * 请求成功：存在返回值
         *
         * <pre>
         * {
         * "code": "0",
         * "desc": "请求成功",
         * "data": "数据"
         * }
        </pre> *
         *
         * @return 返回成功
         */
        fun respSuccess(data: Any?): String {
            return resp(data, RespEnum.SUCCESS)
        }

        private fun resp(respEnum: RespEnum?): String {
            return resp(null, respEnum)
        }

        private fun <T> resp(data: T, respEnum: RespEnum?): String {
            var resp = RespUtil(data, respEnum!!)

            // 将对象转成 json
            val writeValueAsString = objectMapper.writeValueAsString(resp)
            return writeValueAsString
        }
    }
}