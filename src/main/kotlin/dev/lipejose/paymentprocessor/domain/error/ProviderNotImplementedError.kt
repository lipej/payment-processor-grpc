package dev.lipejose.paymentprocessor.domain.error

import dev.lipejose.paymentprocessor.PaymentResponse

class ProviderNotImplementedError(private val provider: String, private val orderId: String) {
    private val code: Int = 500

    fun build(): PaymentResponse {
        return PaymentResponse.newBuilder()
            .setMessage("ERROR: provider $provider not implemented")
            .setSuccess(false)
            .setOrderId(orderId)
            .setCode(code)
            .build()
    }
}