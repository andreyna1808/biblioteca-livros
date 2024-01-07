package com.andreyna.bibliotecalivros.enums

enum class Errors(val code: String, val message: String) {
    B001("B-001", "Book [%s] not exists"), // o %s seria os parametros a ser recebidos dentro do erros.BL0001.message.format(passa eles aqui)
    C001("C-001", "Customer [%s] not exists"),

    B101("B-101", "Cannot update book with status [%s]"),
    C101("C-101", "Cannot update customer with status [%s]")

}