package dev.lipejose.paymentprocessor.presentation.endpoints


import dev.lipejose.paymentprocessor.PaymentRequest
import dev.lipejose.paymentprocessor.PaymentResponse
import dev.lipejose.paymentprocessor.PaymentServiceGrpcKt
import dev.lipejose.paymentprocessor.domain.error.ProviderNotImplementedError
import dev.lipejose.paymentprocessor.domain.services.PaymentService
import dev.lipejose.paymentprocessor.domain.protocols.PaymentProvider
import dev.lipejose.paymentprocessor.main.factories.ProvidersFactory
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@Singleton
class PaymentEndpoint : PaymentServiceGrpcKt.PaymentServiceCoroutineImplBase() {

    override suspend fun process(request: PaymentRequest): PaymentResponse {
        return when (val worker = ProvidersFactory().create(request.provider)) {
            is PaymentProvider -> PaymentService(worker).process(request)
            else -> ProviderNotImplementedError(request.provider,request.order.orderId).build()
        }
    }

    override fun processStream(requests: Flow<PaymentRequest>): Flow<PaymentResponse> = flow {
        requests.collect {
            emit(
                when (val worker = ProvidersFactory().create(it.provider)) {
                    is PaymentProvider -> PaymentService(worker).process(it)
                    else -> ProviderNotImplementedError(it.provider, it.order.orderId).build()
                }
            )
        }
    }
}