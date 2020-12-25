package com.github.pethome.common.base

/**
 * @author Chimm Huang
 */
interface BaseRepo<DO : BaseDomain, DTO : BaseDTO> {

    /**
     * 新增单个对象
     *
     * @param entry 对象的`null`值也插入数据
     * @return 返回成功条数
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
     * 新增多个对象
     *
     * @param list 实体对象List, 对象的`null`值也插入数据
     * @return 返回成功条数
     */
    fun insertList(list: List<DTO>): List<DTO>

    /**
     * 根据id删除单个
     *
     * @param id 主键id
     * @return 返回成功条数
     */
    fun deleteById(id: Long)

    /**
     * 根据id删除多个
     *
     * @param ids id数组
     * @return 返回成功条数
     */
    fun deleteBatch(vararg ids: Long)

    /**
     * 根据id删除多个
     *
     * @param ids 主键id逗号分割："1, 2, 3, ..."
     * @return 返回成功条数
     */
    fun deleteBatch(ids: String)

    /**
     * 根据id删除多个
     *
     * @param ids 主键id List
     * @return 返回成功条数
     */
    fun deleteBatch(ids: List<Long>?)

    /**
     * 根据id修改
     *
     * @param entry 实体`null`值也更新
     * @return 返回成功条数
     */
    fun updateById(entry: DTO)

    /**
     * 根据id修改
     *
     * @param entry 实体`null`不更新
     * @return 返回成功条数
     */
    fun updateByIdBySelective(entry: DTO)

    /**
     * 针对实体对象不为`null`的属性，where key1 = value1 and key2 = value2 and ...
     *
     * @param entry 实体对象
     * @return 返回单个
     */
    fun selectOne(entry: DTO): DTO

    /**
     * 查询所有列表数据
     *
     * @return `List<DTO>`
     */
    fun selectAll(): List<DTO>

    /**
     * 针对实体对象不为`null`的属性，where key1 = value1 and key2 = value2 and ...
     *
     * @param entry 实体对象
     * @return 返回所有符合条件对象
     */
    fun select(entry: DTO): List<DTO>

    /**
     * 根据id查询单个对象
     *
     * @param id 主键id
     * @return 返回单个对象
     */
    fun selectById(id: Long): DTO

    /**
     * 根据多个id查询
     *
     * @param ids 主键id逗号分割："1, 2, 3, 4"
     * @return 返回对象列表
     */
    fun selectByIds(ids: String): List<DTO>

    /**
     * 根据id列表查询
     *
     * @param ids 主键id列表
     * @return 返回对象列表
     */
    fun selectByIdList(ids: List<Long>): List<DTO>
}