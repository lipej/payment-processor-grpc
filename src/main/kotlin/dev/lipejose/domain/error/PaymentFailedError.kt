package dev.lipejose.domain.error

import dev.lipejose.PaymentResponse

class PaymentFailedError(private val message: String) {
    fun build(): PaymentResponse {
        return PaymentResponse.newBuilder()
            .setMessage(message)
            .setSuccess(false)
            .build()
    }
}