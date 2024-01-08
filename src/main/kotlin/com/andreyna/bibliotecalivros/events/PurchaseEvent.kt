package com.andreyna.bibliotecalivros.events

import com.andreyna.bibliotecalivros.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel
): ApplicationEvent(source)