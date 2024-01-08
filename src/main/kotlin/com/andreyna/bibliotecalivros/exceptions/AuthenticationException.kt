package com.andreyna.bibliotecalivros.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception()