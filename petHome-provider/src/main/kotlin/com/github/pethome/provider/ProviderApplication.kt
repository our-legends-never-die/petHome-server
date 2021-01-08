package com.github.pethome.provider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Chimm Huang
 */
@SpringBootApplication
open class ProviderApplication

fun main(args: Array<String>) {
    runApplication<ProviderApplication>(*args)
}