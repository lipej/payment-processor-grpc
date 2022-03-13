package dev.lipejose.paymentprocessor.domain.services

import dev.lipejose.paymentprocessor.PaymentRequest
import dev.lipejose.paymentprocessor.PaymentResponse
import dev.lipejose.paymentprocessor.domain.entities.Card
import dev.lipejose.paymentprocessor.domain.entities.Customer
import dev.lipejose.paymentprocessor.domain.entities.Order
import dev.lipejose.paymentprocessor.domain.protocols.PaymentProvider

class PaymentService(private val provider: PaymentProvider) {
    fun process(request: PaymentRequest): PaymentResponse {
        val card = Card(request.card.number, request.card.ccv, request.card.exp, request.card.name, request.card.brand)
        val customer = Customer(request.order.customer.firstName, request.order.customer.lastName)
        val order = Order(request.order.orderId, request.order.amount, customer)

        return provider.execute(card, order)
    }
}