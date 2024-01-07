package com.andreyna.bibliotecalivros.exception.Response

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorsResponse>?
)