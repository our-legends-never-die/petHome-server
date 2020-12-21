package com.github.pethome.controller

import com.github.pethome.domain.Demo
import com.github.pethome.mapper.DemoMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chimm Huang
 * @date 2020/12/21
 */
@RestController("/demo")
class DemoController {

    @Autowired
    lateinit var demoMapper: DemoMapper

    @GetMapping
    fun demo(): List<Demo> {
        return demoMapper.selectAll()
    }
}