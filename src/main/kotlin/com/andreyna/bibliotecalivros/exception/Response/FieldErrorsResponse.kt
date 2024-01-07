package com.andreyna.bibliotecalivros.exception.Response

data class FieldErrorsResponse (
    var message: String,
    var field: String
)