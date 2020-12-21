package com.github.pethome

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Chimm Huang
 */
@SpringBootApplication(scanBasePackages = ["com.github.pethome"])
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}