package com.github.pethome.mobile.bff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chimm Huang
 * @date 2021/01/08
 */
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
open class MobileBffApplication {

    @GetMapping("/health")
    fun health(): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    runApplication<MobileBffApplication>(*args)
}


