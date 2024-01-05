package com.andreyna.bibliotecalivros.Controller

import com.andreyna.bibliotecalivros.Model.BookModel
import com.andreyna.bibliotecalivros.Service.BookService
import com.andreyna.bibliotecalivros.Service.CustomerService
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
    fun getFilterBook(@RequestParam name: String?): List<BookModel> {
       return bookService.getFilterBook(name)
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