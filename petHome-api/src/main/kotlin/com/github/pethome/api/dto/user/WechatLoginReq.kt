package com.github.pethome.api.dto.user

import javax.validation.constraints.NotBlank

/**
 * @author Chimm Huang
 */
class WechatLoginReq(@field:NotBlank var code: String)


