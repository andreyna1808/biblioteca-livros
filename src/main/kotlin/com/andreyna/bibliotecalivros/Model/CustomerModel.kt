package com.andreyna.bibliotecalivros.Model

import com.andreyna.bibliotecalivros.enums.BookStatus
import com.andreyna.bibliotecalivros.enums.CustomerStatus
import com.andreyna.bibliotecalivros.enums.Errors
import com.andreyna.bibliotecalivros.exception.Request.BadRequestException
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "customers") // Faz referência a tabela do banco de dados
data class CustomerModel (

    @Id // É um primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column // É uma coluna da tabel customers do banco de dados
    var name: String,

    @Column // É uma coluna da tabel customers do banco de dados
    var email: String,
){
    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus? = CustomerStatus.ATIVO
        set(value) {
            if (field == CustomerStatus.DELETADO || field == CustomerStatus.INATIVO) {
                throw BadRequestException(Errors.C101.message.format(field), Errors.C101.code)
            }
            field = value
        }
    constructor(
        id: Int? = null,
        name: String,
        email: String,
        status: CustomerStatus? = CustomerStatus.ATIVO
    ): this(id, name, email) {
        this.status = status
    }
}