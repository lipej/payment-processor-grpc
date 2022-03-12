package dev.lipejose.main.factories


import dev.lipejose.infra.providers.CieloProvider
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class ProvidersFactorySpec extends Specification {

    @Inject
    ProvidersFactory providersFactory

    @Unroll
    void "should get null when provider was not implemented"() {
        when:
        def result = providersFactory.create(provider)

        then:
        result == expected

        where:
        provider    | expected
        'pagseguro' | null
        'stone'     | null

    }

    @Unroll
    void "should return a PaymentProvider when is implemented"() {
        when:
        def result = providersFactory.create(provider)

        then:
        result in expected

        where:
        provider | expected
        'cielo'  | CieloProvider
    }

}
