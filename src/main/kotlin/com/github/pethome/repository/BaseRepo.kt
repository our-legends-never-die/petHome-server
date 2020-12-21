package com.github.pethome.repository

import com.github.pethome.domain.BaseDomain
import com.github.pethome.dto.BaseDTO
import tk.mybatis.mapper.entity.Example

/**
 * @author Chimm Huang
 */
interface BaseRepo<DO:BaseDomain, DTO : BaseDTO> {

    /**
     * 查询所有列表数据
     *
     * @return `List<DTO>`
     */
    fun selectAll(): List<DTO>

    /**
     * 根据ID查询条目
     *
     * @param id ID
     * @return `DTO`
     */
    fun selectById(id: Long?): DTO

    /**
     * 针对实体对象不为`null`的属性，where key1 = value1 and key2 = value2 and ...
     *
     * @param entry 实体对象
     * @return 返回单个
     */
    fun selectOne(entry: DTO): DTO

    /**
     * 针对实体对象不为`null`的属性，where key1 = value1 and key2 = value2 and ...
     *
     * @param entry 实体对象
     * @return 返回所有符合条件对象
     */
    fun select(entry: DTO): List<DTO>

    /**
     * 根据example条件查询集合
     *
     * @param example 查询条件
     * @return
     */
    fun selectByExample(example: Example?): List<DTO>


    /**
     * 根据example条件查询单条数据
     *
     * @param example 查询条件
     * @return
     */
    fun selectOneByExample(example: Example?): DTO

    /**
     * 向数据库中新增一条记录
     *
     * @param entry    DTO 实体对象
     * @return `DTO`
     */
    fun insert(entry: DTO): DTO

    /**
     * 新增单个对象
     *
     * @param entry 对象的`null`值不插入数据
     * @return 返回成功条数
     */
    fun insertSelective(entry: DTO): DTO

    /**
     * 根据主键ID修改条目
     *
     * @param entry DTO
     */
    fun updateById(entry: DTO)

    /**
     * 根据主键ID选择性修改条目
     *
     * @param entry DTO
     */
    fun updateByIdBySelective(entry: DTO)

    /**
     * 根据主键ID删除条目
     *
     * @param id ID
     */
    fun deleteById(id: Long?)

    /**
     * 根据ID数组删除条目
     *
     * @param ids ID数组
     */
    fun deleteBatch(vararg ids: Long?)

    /**
     * 批量删除数据，多个以英文逗号分隔开
     *
     * @param ids ID组
     */
    fun deleteBatch(ids: String?)

    /**
     * 根据ID集合删除条目
     *
     * @param ids ID集合
     */
    fun deleteBatch(ids: List<Long?>?)


    /**
     * 根据example 更新
     *
     * @param entry 更新内容
     * @param example 更新条件
     */
    fun updateByExampleSelective(entry: DTO, example: Example?)
}