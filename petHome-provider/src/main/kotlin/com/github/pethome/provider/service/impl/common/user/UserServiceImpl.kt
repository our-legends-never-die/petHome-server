package com.github.pethome.provider.service.impl.common.user

import com.github.pethome.api.dto.user.UserDTO
import com.github.pethome.common.enums.DeleteFlagEnum
import com.github.pethome.provider.repository.impl.user.UserRepository
import com.github.pethome.provider.service.user.UserService
import org.springframework.stereotype.Service

/**
 * @author Chimm Huang
 */
@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun selectByWechatOpenId(openId: String): UserDTO? {
        return userRepository.selectOne(UserDTO().apply {
            wechatOpenId = openId
            delFlag = DeleteFlagEnum.NORMAL.delFlag
        })
    }

    override fun insertSelective(userDTO: UserDTO): UserDTO {
        return userRepository.insertSelective(userDTO)
    }
}