package com.andreyna.bibliotecalivros.events.listener

import com.andreyna.bibliotecalivros.events.PurchaseEvents
import com.andreyna.bibliotecalivros.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(private val purchaseService: PurchaseService) {

    @EventListener
    fun listen(purchaseEvents: PurchaseEvents) {
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvents.purchaseModel.copy(nfe = nfe)

        purchaseService.updatePurchaseService(purchaseModel)
    }

}