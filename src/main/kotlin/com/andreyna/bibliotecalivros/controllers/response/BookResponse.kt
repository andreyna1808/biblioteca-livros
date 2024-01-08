package com.andreyna.bibliotecalivros.controller.response

import com.andreyna.bibliotecalivros.enums.BookStatus
import com.andreyna.bibliotecalivros.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)