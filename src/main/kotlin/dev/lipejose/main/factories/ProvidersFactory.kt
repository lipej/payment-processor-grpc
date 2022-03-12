package dev.lipejose.main.factories

import dev.lipejose.domain.services.protocols.PaymentProvider
import dev.lipejose.infra.providers.CieloProvider
import io.micronaut.context.annotation.Factory

@Factory
class ProvidersFactory {
    fun create(provider: String): PaymentProvider? = when (provider) {
        "cielo" -> CieloProvider()
        else -> null
    }
}