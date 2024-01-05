package com.andreyna.bibliotecalivros.Repository

import com.andreyna.bibliotecalivros.Model.BookModel
import com.andreyna.bibliotecalivros.Model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {

    fun findByNameContaining(name: String): List<BookModel>
    fun findByCustomerId(customerId: CustomerModel): List<BookModel>
}