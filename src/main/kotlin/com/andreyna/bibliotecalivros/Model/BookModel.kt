package com.andreyna.bibliotecalivros.Model

import com.andreyna.bibliotecalivros.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "books") // Faz referência a tabela do banco de dados
data class BookModel (

    @Id // É um primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne // Muitos para um
    @JoinColumn(name = "customer_id") // Vou me basear no customer_id
    var customerId: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING) // Esse cara é um enum que recebe valor especifico
    var status: BookStatus? = BookStatus.ATIVO // Só aceita valores já pre-definido pelo enum que eu criei
        set(value) {
            if (field == BookStatus.DELETADO || field == BookStatus.ATIVO) {
                throw Exception("Não é possível alterar um livro com status ${field}")
            }
            field = value
        }
    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customerId: CustomerModel? = null,
        status: BookStatus? = BookStatus.ATIVO
    ): this(id, name, price, customerId) {
        this.status = status
    }
}