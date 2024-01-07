package com.andreyna.bibliotecalivros.exception.Request

class NotFoundException(override val message: String, val errorCode: String): Exception() {}
class BadRequestException(override val message: String, val errorCode: String): Exception() {}
