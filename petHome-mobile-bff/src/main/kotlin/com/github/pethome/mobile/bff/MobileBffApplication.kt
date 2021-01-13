package com.github.pethome.mobile.bff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

/**
 * @author Chimm Huang
 */
@RestController
@EnableDiscoveryClient
@EnableFeignClients(basePackages = ["com.github.pethome.api"])
@SpringBootApplication
open class MobileBffApplication {

    @GetMapping("/health")
    fun health(): Boolean {
        return true
    }

    @Autowired
    private lateinit var restTemplateBuilder: RestTemplateBuilder

    @Bean
    open fun restTemplate(): RestTemplate {
        return restTemplateBuilder.build()
    }

}

fun main(args: Array<String>) {
    runApplication<MobileBffApplication>(*args)
}


