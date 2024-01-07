package com.andreyna.bibliotecalivros.service

import com.andreyna.bibliotecalivros.model.BookModel
import com.andreyna.bibliotecalivros.model.CustomerModel
import org.springframework.stereotype.Service
import com.andreyna.bibliotecalivros.repository.BookRepository
import com.andreyna.bibliotecalivros.enums.BookStatus
import com.andreyna.bibliotecalivros.enums.Errors
import com.andreyna.bibliotecalivros.exception.Request.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Service
class BookService (val bookRepository: BookRepository) {

    /* GET */
    fun getAllBooks(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun getBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.B001.message.format(id), Errors.B001.code) }
    }

    fun getAllByIds(bookIds: List<Int>): List<BookModel> {
        return bookRepository.findAllById(bookIds).toList()
    }

    /* POST */
    fun createBook(book: BookModel) {
        bookRepository.save(book)
    }

    /* PUT */
    fun updateBook(id: Int, book: BookModel) {

        if(!bookRepository.existsById(book.id!!)) {
            throw Exception( NotFoundException(Errors.B001.message.format(id), Errors.B001.code) )
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

    /* OTHERS */
    fun purchase(books: MutableList<BookModel>) {
        books.map { it.status = BookStatus.VENDIDO }
        bookRepository.saveAll(books)
    }
}