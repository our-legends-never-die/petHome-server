package com.github.pethome.provider.common

import com.github.pethome.api.dto.BaseDTO
import com.vip.vjtools.vjkit.mapper.BeanMapper
import org.springframework.beans.factory.annotation.Autowired
import java.lang.reflect.ParameterizedType
import java.time.LocalDateTime

/**
 * @author Chimm Huang
 */
abstract class BaseRepoImpl<DO : BaseDomain, DTO : BaseDTO> : BaseRepo<DO, DTO> {

    @Autowired
    private lateinit var mapper: Mapper<DO>

    protected var doClass: Class<DO>? = null
    protected var dtoClass: Class<DTO>? = null

    init {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val typeArguments = parameterizedType.actualTypeArguments
        doClass = typeArguments[0] as Class<DO>
        dtoClass = typeArguments[1] as Class<DTO>
    }

    open fun mapper(): Mapper<DO> {
        return mapper
    }

    private fun preInsert(dto: DTO) {
        dto.gmtCreate = LocalDateTime.now()
        dto.gmtModified = LocalDateTime.now()
        // todo 用户信息的设置
    }

    private fun preInsert(dtoList: List<DTO>) {
        for (dto in dtoList)
            this.preInsert(dto)
    }

    override fun insert(entry: DTO): DTO {
        preInsert(entry)
        val domain = BeanMapper.map(entry, doClass)
        mapper.insert(domain)
        entry.id = domain.id
        return entry
    }

    override fun insertSelective(entry: DTO): DTO {
        preInsert(entry)
        val domain = BeanMapper.map(entry, doClass)
        mapper.insertSelective(domain)
        entry.id = domain.id
        return entry
    }

    override fun insertList(list: List<DTO>): List<DTO> {
        if (list.isEmpty())
            return list

        preInsert(list)
        val domainList = BeanMapper.mapList(list, doClass)
        mapper.insertList(domainList)

        for (i in list.indices) {
            list[i].id = domainList[i].id
        }
        return list
    }

    override fun deleteById(id: Long) {
        mapper.deleteByPrimaryKey(id)
    }

    override fun deleteBatch(vararg ids: Long) {
        this.deleteBatch(ids.toList())
    }

    override fun deleteBatch(ids: String) {
        mapper.deleteByIds(ids)
    }

    override fun deleteBatch(ids: List<Long>?) {
        if (ids == null || ids.isEmpty())
            return

        mapper.deleteByIdList(ids)
    }

    override fun updateById(entry: DTO) {
        mapper.updateByPrimaryKey(BeanMapper.map(entry,doClass))
    }

    override fun updateByIdBySelective(entry: DTO) {
        mapper.updateByPrimaryKeySelective(BeanMapper.map(entry,doClass))
    }

    override fun selectOne(entry: DTO): DTO? {
        val domain = mapper.selectOne(BeanMapper.map(entry, doClass))
        return BeanMapper.map(domain,dtoClass)
    }

    override fun selectAll(): List<DTO> {
        val domainList = mapper.selectAll()
        return BeanMapper.mapList(domainList, dtoClass)
    }

    override fun select(entry: DTO): List<DTO> {
        val domainList = mapper.select(BeanMapper.map(entry, doClass))
        return BeanMapper.mapList(domainList,dtoClass)
    }

    override fun selectById(id: Long): DTO {
        val domain = mapper.selectByPrimaryKey(id)
        return BeanMapper.map(domain,dtoClass)
    }

    override fun selectByIds(ids: String): List<DTO> {
        val domainList = mapper.selectByIds(ids)
        return BeanMapper.mapList(domainList,dtoClass)
    }

    override fun selectByIdList(ids: List<Long>): List<DTO> {
        val domainList = mapper.selectByIdList(ids)
        return BeanMapper.mapList(domainList,dtoClass)
    }

}