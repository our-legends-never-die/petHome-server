package com.github.pethome.provider.repository.impl.user

import com.github.pethome.api.dto.user.UserDTO
import com.github.pethome.provider.common.BaseRepoImpl
import com.github.pethome.provider.domain.user.UserDO
import org.springframework.stereotype.Repository

/**
 * @author Chimm Huang
 */
@Repository
open class UserRepository : BaseRepoImpl<UserDO, UserDTO>() {

}