package com.github.pethome.provider.resource.impl.user

import com.github.pethome.api.dto.user.UserDTO
import com.github.pethome.api.resource.user.UserResource
import com.github.pethome.provider.service.user.UserService
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chimm Huang
 */
@RestController
open class UserResourceImpl(
    private val userService: UserService
) : UserResource {

    override fun selectByWechatOpenId(openId: String): UserDTO? {
        return userService.selectByWechatOpenId(openId)
    }

    override fun insertSelective(userDTO: UserDTO): UserDTO {
        return userService.insertSelective(userDTO)
    }

}