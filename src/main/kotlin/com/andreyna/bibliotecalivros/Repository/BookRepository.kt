package com.andreyna.bibliotecalivros.Repository

import com.andreyna.bibliotecalivros.Model.BookModel
import com.andreyna.bibliotecalivros.Model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {

    fun findAll(pageable: Pageable): Page<BookModel>
    fun findByCustomerId(customerId: CustomerModel): List<BookModel>
}