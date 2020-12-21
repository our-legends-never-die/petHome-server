package com.github.pethome.mapper

import com.github.pethome.domain.Demo
import org.apache.ibatis.annotations.Mapper
import tk.mybatis.mapper.common.BaseMapper

/**
 * @author Chimm Huang
 * @date 2020/12/21
 */
@Mapper
interface DemoMapper:BaseMapper<Demo> {
}