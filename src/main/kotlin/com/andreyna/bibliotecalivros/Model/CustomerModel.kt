package com.andreyna.bibliotecalivros.Model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "customers") // Faz referência a tabela do banco de dados
data class CustomerModel (

    @Id // É um primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column // É uma coluna da tabel customers do banco de dados
    var name: String,

    @Column // É uma coluna da tabel customers do banco de dados
    var email: String)