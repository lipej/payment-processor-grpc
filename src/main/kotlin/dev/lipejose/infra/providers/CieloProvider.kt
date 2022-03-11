package dev.lipejose.infra.providers

import dev.lipejose.PaymentResponse
import dev.lipejose.domain.entities.Card
import dev.lipejose.domain.services.protocols.PaymentProvider

class CieloProvider: PaymentProvider {
    override fun execute(card: Card, amount: String): PaymentResponse {
        throw IllegalArgumentException("not yet implemented" + card.name)
    }
}