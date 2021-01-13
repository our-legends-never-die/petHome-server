package com.github.pethome.common.exception

/**
 * @author Chimm Huang
 */
class ServerException : PetException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}