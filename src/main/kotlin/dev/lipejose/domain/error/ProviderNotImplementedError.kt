package dev.lipejose.domain.error

import dev.lipejose.PaymentResponse

class ProviderNotImplementedError(private val provider: String) {
    fun build(): PaymentResponse {
        return PaymentResponse.newBuilder()
            .setMessage("ERROR: provider $provider not implemented")
            .setSuccess(false)
            .build()
    }
}