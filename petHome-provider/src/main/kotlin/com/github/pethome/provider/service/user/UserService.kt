package com.github.pethome.provider.service.user

import com.github.pethome.api.dto.user.UserDTO

/**
 * @author Chimm Huang
 */
interface UserService {

    /**
     * 根据 微信openid 查询用户信息
     *
     * @param openId 微信 openId
     */
    fun selectByWechatOpenId(openId: String): UserDTO?

    /**
     * 插入用户信息
     *
     * @param userDTO 用户信息
     */
    fun insertSelective(userDTO: UserDTO): UserDTO
}