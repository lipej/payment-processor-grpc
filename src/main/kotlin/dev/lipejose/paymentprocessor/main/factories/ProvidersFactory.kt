package dev.lipejose.paymentprocessor.main.factories

import dev.lipejose.paymentprocessor.domain.protocols.PaymentProvider
import dev.lipejose.paymentprocessor.infra.providers.CieloProvider
import io.micronaut.context.annotation.Factory

@Factory
class ProvidersFactory {
    fun create(provider: String): PaymentProvider? = when (provider) {
        "cielo" -> CieloProvider()
        else -> null
    }
}