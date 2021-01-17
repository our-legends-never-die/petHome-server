package com.github.pethome.common.enums

/**
 * @author Chimm Huang
 */
enum class DeleteFlagEnum(
    var delFlag: Int,
    var description:String
) {

    NORMAL(0,"正常"),
    DELETED(1,"已删除")
    ;
}