package com.andreyna.bibliotecalivros.controller.mapper

import com.andreyna.bibliotecalivros.controller.request.PostPurchaseRequest
import com.andreyna.bibliotecalivros.model.PurchaseModel
import com.andreyna.bibliotecalivros.service.BookService
import com.andreyna.bibliotecalivros.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }

}