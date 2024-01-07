package com.andreyna.bibliotecalivros.controller.mapper

import com.andreyna.bibliotecalivros.model.PurchaseModel
import com.andreyna.bibliotecalivros.service.BookService
import com.andreyna.bibliotecalivros.service.CustomerService

class PurchaseMapper(private val bookService: BookService, private val customerService: CustomerService) {
    fun toModel(request: PurchaseModel): PurchaseModel {
        val customer = customerService.getCustomerById(request.customer.id!!)
        val books = bookService.getAllByIds(request.books.map { it.id!! })
        
        return PurchaseModel(customer = customer, books = books.toMutableList(), price = books.sumOf { it.price })
    }
}