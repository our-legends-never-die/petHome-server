package com.github.pethome.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("swagger")
class SwaggerProperties {

    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    var enable: Boolean = false

    /**
     * 项目应用名
     */
    var applicationName: String? = null

    /**
     * 项目版本信息
     */
    var applicationVersion: String? = null

    /**
     * 项目描述信息
     */
    var applicationDescription: String? = null

    /**
     * 接口调试地址
     */
    var tryHost: String? = null
}