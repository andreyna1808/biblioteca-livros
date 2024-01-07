package com.andreyna.bibliotecalivros.events.listener

import com.andreyna.bibliotecalivros.events.PurchaseEvents
import com.andreyna.bibliotecalivros.service.BookService
import com.andreyna.bibliotecalivros.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateSoldListener(private val bookService: BookService) {

    @EventListener
    fun listen(purchaseEvents: PurchaseEvents) {
        bookService.purchase(purchaseEvents.purchaseModel.books)
    }

}