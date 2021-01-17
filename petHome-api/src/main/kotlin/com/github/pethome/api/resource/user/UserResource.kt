package com.github.pethome.api.resource.user

import com.github.pethome.api.dto.user.UserDTO
import com.github.pethome.common.constant.ApiConstant.PROVIDER_URL_PREFIX_USER
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author Chimm Huang
 */
@FeignClient(value = "\${petHome.providerName}")
interface UserResource {

    /**
     * 根据 微信openid 查询用户信息
     *
     * @param openId 微信 openId
     */
    @RequestMapping("$PROVIDER_URL_PREFIX_USER/selectByWechatOpenId")
    fun selectByWechatOpenId(@RequestParam("openId") openId: String): UserDTO?

    /**
     * 插入用户信息
     *
     * @param userDTO 用户信息
     */
    @RequestMapping("$PROVIDER_URL_PREFIX_USER/insertSelective")
    fun insertSelective(@RequestBody userDTO: UserDTO): UserDTO


}