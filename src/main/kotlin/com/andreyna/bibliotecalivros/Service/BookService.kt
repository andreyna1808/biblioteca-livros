package com.andreyna.bibliotecalivros.Service

import com.andreyna.bibliotecalivros.Model.BookModel
import com.andreyna.bibliotecalivros.Model.CustomerModel
import org.springframework.stereotype.Service
import com.andreyna.bibliotecalivros.Repository.BookRepository
import com.andreyna.bibliotecalivros.enums.BookStatus

@Service
class BookService (val bookRepository: BookRepository) {

    /* GET */
    fun getFilterBook(name: String?): List<BookModel> {
        name?.let {
            return bookRepository.findByNameContaining(name)
        }

        return bookRepository.findAll().toList()
    }

    fun getBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    /* POST */
    fun createBook(book: BookModel) {
        bookRepository.save(book)
    }

    /* PUT */
    fun updateBook(id: Int, book: BookModel) {

        if(!bookRepository.existsById(book.id!!)) {
            throw Exception()
        }

        bookRepository.save(book)
    }

    /* DELETE */
    fun deleteBook(id: Int) {
        val book = getBookById(id)

        book.status = BookStatus.CANCELADO
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomerId(customer)

        for (book in books) {
            book.status = BookStatus.DELETADO
        }

        bookRepository.saveAll(books)
    }
}