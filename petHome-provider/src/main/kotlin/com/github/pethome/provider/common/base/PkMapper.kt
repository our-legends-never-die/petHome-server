package com.github.pethome.provider.common.base

import tk.mybatis.mapper.additional.idlist.IdListMapper
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.ExampleMapper
import tk.mybatis.mapper.common.IdsMapper
import tk.mybatis.mapper.common.special.InsertListMapper

/**
 * @author Chimm Huang
 */
interface PkMapper<T, K> : BaseMapper<T>, ExampleMapper<T>, IdsMapper<T>, InsertListMapper<T>, IdListMapper<T, K> {
}