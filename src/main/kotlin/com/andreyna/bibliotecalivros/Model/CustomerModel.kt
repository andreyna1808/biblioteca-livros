package com.andreyna.bibliotecalivros.Model

import com.andreyna.bibliotecalivros.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name = "customers") // Faz referência a tabela do banco de dados
data class CustomerModel (

    @Id // É um primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column // É uma coluna da tabel customers do banco de dados
    var name: String,

    @Column // É uma coluna da tabel customers do banco de dados
    var email: String,

    @Column // É uma coluna da tabel customers do banco de dados
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus? = CustomerStatus.ATIVO

)