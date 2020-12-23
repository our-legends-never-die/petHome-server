package com.github.pethome.mapper.user

import com.github.pethome.domain.user.UserDO
import org.apache.ibatis.annotations.Mapper
import tk.mybatis.mapper.common.BaseMapper

/**
 * @author Chimm Huang
 */
@Mapper
interface UserMapper : BaseMapper<UserDO> {
}