package dev.lipejose.domain.services

import dev.lipejose.PaymentRequest
import dev.lipejose.PaymentResponse
import dev.lipejose.domain.entities.Card
import dev.lipejose.domain.services.protocols.PaymentProvider

class PaymentService(private val provider: PaymentProvider) {
    fun process(payment: PaymentRequest): PaymentResponse {
        val card = Card(payment.number, payment.ccv, payment.exp, payment.name)
        return provider.execute(card, payment.amount)
    }
}