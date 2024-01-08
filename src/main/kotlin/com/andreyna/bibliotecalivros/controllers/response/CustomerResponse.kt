package com.andreyna.bibliotecalivros.controller.response

import com.andreyna.bibliotecalivros.enums.CustomerStatus

data class CustomerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)