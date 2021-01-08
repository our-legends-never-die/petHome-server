package com.github.pethome.provider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chimm Huang
 */
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
open class ProviderApplication {
    @GetMapping("/health")
    fun health(): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    runApplication<ProviderApplication>(*args)
}