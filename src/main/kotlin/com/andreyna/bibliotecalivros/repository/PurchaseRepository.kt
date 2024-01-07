package com.andreyna.bibliotecalivros.repository

import com.andreyna.bibliotecalivros.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository:CrudRepository<PurchaseModel, Int> {
}