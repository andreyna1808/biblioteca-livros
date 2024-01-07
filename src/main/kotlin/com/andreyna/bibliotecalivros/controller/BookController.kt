package com.andreyna.bibliotecalivros.controller

import com.andreyna.bibliotecalivros.model.BookModel
import com.andreyna.bibliotecalivros.service.BookService
import com.andreyna.bibliotecalivros.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(val bookService: BookService, val customerService: CustomerService) {

    /* GET */
    @GetMapping
    fun getFilterBook(@RequestParam name: String?, @PageableDefault(page = 1, size = 10) pageable: Pageable): Page<BookModel> {
       return bookService.getAllBooks(pageable)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): BookModel {
        return bookService.getBookById(id)
    }

    /* POST */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: BookModel) {
        val customerId = request.customerId?.id ?: throw IllegalArgumentException()
        val customer = customerService.getCustomerById(customerId)
        bookService.createBook(request)
    }

    /* PUT */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        fun updateBook(@PathVariable id: Int, @RequestBody book: BookModel) {
        bookService.updateBook(id, book)
    }

    /* DELETE */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        return bookService.deleteBook(id)
    }
}