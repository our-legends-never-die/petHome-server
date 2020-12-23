package com.github.pethome.domain

import javax.persistence.Table

/**
 * @author Chimm Huang
 */
@Table(name = "demo")
class Demo: BaseDomain() {
    var name: String? = null
}