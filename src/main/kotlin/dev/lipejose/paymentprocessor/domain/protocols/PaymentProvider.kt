package dev.lipejose.paymentprocessor.domain.protocols

import dev.lipejose.paymentprocessor.PaymentResponse
import dev.lipejose.paymentprocessor.domain.entities.Card
import dev.lipejose.paymentprocessor.domain.entities.Order

interface PaymentProvider {
    fun execute(card: Card, order: Order): PaymentResponse
}