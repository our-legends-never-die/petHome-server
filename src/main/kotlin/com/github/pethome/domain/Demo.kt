package com.github.pethome.domain

import javax.persistence.Table

/**
 * @author Chimm Huang
 * @date 2020/12/21
 */
@Table(name = "demo")
class Demo: BaseDomain() {
    var name: String? = null
}