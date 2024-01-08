package com.andreyna.bibliotecalivros.controller.request

import com.andreyna.bibliotecalivros.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailAvailable(message = "Email em uso")
    var email: String,

    @field:NotEmpty(message = "Senha deve ser informada")
    var password: String
)