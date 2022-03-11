package dev.lipejose.domain.services.protocols

import dev.lipejose.PaymentResponse
import dev.lipejose.domain.entities.Card
import dev.lipejose.domain.entities.Order

interface PaymentProvider {
    fun execute(card: Card, order: Order): PaymentResponse
}