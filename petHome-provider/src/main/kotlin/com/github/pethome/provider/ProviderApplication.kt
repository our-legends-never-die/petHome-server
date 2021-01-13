package com.github.pethome.provider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tk.mybatis.spring.annotation.MapperScan

/**
 * @author Chimm Huang
 */
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan(basePackages = ["com.github.pethome.provider.common","com.github.pethome.provider.mapper"])
open class ProviderApplication {

    @GetMapping("/health")
    fun health(): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    runApplication<ProviderApplication>(*args)
}