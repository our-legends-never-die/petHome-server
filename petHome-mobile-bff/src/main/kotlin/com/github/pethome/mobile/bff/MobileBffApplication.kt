package com.github.pethome.mobile.bff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Chimm Huang
 * @date 2021/01/08
 */
@SpringBootApplication
open class MobileBffApplication

fun main(args: Array<String>) {
    runApplication<MobileBffApplication>(*args)
}
