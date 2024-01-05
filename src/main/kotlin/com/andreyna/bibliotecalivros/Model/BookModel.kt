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

    @Column
    @Enumerated(EnumType.STRING) // Esse cara é um enum que recebe valor especifico
    var status: BookStatus? = null, // Só aceita valores já pre-definido pelo enum que eu criei

    @ManyToOne // Muitos para um
    @JoinColumn(name = "customer_id") // Vou me basear no customer_id
    var customerId: CustomerModel? = null
)