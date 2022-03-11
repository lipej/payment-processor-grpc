package dev.lipejose.domain.services.protocols

import dev.lipejose.PaymentResponse
import dev.lipejose.domain.entities.Card

interface PaymentProvider {
    fun execute(card: Card, amount: String): PaymentResponse
}