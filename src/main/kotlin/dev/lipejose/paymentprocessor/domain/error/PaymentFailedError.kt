package dev.lipejose.paymentprocessor.domain.error

import dev.lipejose.paymentprocessor.PaymentResponse

class PaymentFailedError(private val message: String, private val code: Int) {
    fun build(): PaymentResponse {
        return PaymentResponse.newBuilder()
            .setMessage(message)
            .setSuccess(false)
            .setCode(code)
            .build()
    }
}