package com.andreyna.bibliotecalivros.repository

import com.andreyna.bibliotecalivros.enums.BookStatus
import com.andreyna.bibliotecalivros.model.BookModel
import com.andreyna.bibliotecalivros.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>

//    fun findAll(pageable: Pageable): Page<BookModel>

}