package com.andreyna.bibliotecalivros.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}