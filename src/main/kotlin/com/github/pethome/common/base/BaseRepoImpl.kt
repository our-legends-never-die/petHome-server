package com.github.pethome.common.base

import org.springframework.beans.BeanWrapperImpl
import org.springframework.beans.factory.annotation.Autowired
import tk.mybatis.mapper.common.BaseMapper
import java.lang.reflect.ParameterizedType
import java.time.LocalDateTime

/**
 * @author Chimm Huang
 */
abstract class BaseRepoImpl<M : BaseMapper<DO>, DO : BaseDomain, DTO : BaseDTO>() : BaseRepo<DO, DTO> {

    @Autowired
    private lateinit var mapper: M

    protected var gendricTypeOfDO: Class<DO>? = null
    protected var gendricTypeOfDTO: Class<DTO>? = null

    init {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val typeArguments = parameterizedType.actualTypeArguments
        gendricTypeOfDO = typeArguments[1] as Class<DO>
        gendricTypeOfDTO = typeArguments[2] as Class<DTO>
    }

    open fun mapper(): M {
        return mapper
    }

    private fun preInsert(dto: DTO) {
        dto.gmtCreate = LocalDateTime.now()
    }

    override fun insert(entry: DTO): DTO {
        return entry
    }

}