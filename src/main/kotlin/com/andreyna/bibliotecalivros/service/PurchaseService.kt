package com.andreyna.bibliotecalivros.service

import com.andreyna.bibliotecalivros.events.PurchaseEvents
import com.andreyna.bibliotecalivros.model.PurchaseModel
import com.andreyna.bibliotecalivros.repository.PurchaseRepository
import org.springframework.stereotype.Service
import org.springframework.context.ApplicationEventPublisher

@Service
class PurchaseService (private val purchaseRepository: PurchaseRepository, private val applicationEventPublisher: ApplicationEventPublisher) {


    fun createPurchaseService(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseEvents(this, purchaseModel))
    }


    fun updatePurchaseService(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}