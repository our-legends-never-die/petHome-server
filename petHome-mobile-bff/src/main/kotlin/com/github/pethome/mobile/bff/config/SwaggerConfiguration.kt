package com.github.pethome.mobile.bff.config

import io.swagger.models.auth.In
import java.util.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityReference
import springfox.documentation.service.SecurityScheme

import springfox.documentation.spi.service.contexts.SecurityContext


/**
 * @author Chimm Huang
 */
@EnableOpenApi
@Configuration
open class SwaggerConfiguration(var swaggerProperties: SwaggerProperties) {


    @Bean
    open fun createRestApi(): Docket {
        return Docket(DocumentationType.OAS_30)
            // 定义是否开启swagger，false为关闭，可以通过变量控制
            .enable(swaggerProperties.enable)
            // 将api的元信息设置为包含在json ResourceListing响应中。
            .apiInfo(apiInfo())
            // 接口调试地址
            .host(swaggerProperties.tryHost)
            // 选择哪些接口作为swagger的doc发布
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.github.pethome.mobile.bff.controller"))
            .paths(PathSelectors.any())
            .build()
            // 支持的通讯协议集合
            .protocols(setOf("https", "http"))
            // 授权信息设置，必要的header token等认证信息
            .securitySchemes(securitySchemes())
            // 授权信息全局应用
            .securityContexts(securityContexts());
    }

    private fun securitySchemes(): List<SecurityScheme> {
        val apiKey = ApiKey("ph_token", com.github.pethome.common.constant.UserLoginConstant.TOKEN_NAME, In.HEADER.toValue())
        return listOf(apiKey)
    }

    /**
     * API 页面上半部分展示信息
     */
    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title(swaggerProperties.applicationName + " Api 文档")
            .description(swaggerProperties.applicationDescription)
            .contact(Contact("吃茫茫", "https://github.com/our-legends-never-die/petHome-server", "chimmhuang@163.com"))
            .version("Version: " + swaggerProperties.applicationVersion)
            .build()
    }


    /**
     * 授权信息全局应用
     */
    private fun securityContexts(): List<SecurityContext?>? {
        return Collections.singletonList(
            SecurityContext.builder()
                .securityReferences(
                    Collections.singletonList(
                        SecurityReference(
                            "登陆token",
                            arrayOf(AuthorizationScope("global", ""))
                        )
                    )
                )
                .build()
        )
    }
}