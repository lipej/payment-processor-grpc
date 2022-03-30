# Payment Processor gRPC

This app is a payment processor hub that work with gRPC calls and process payment in a payment provider.

### ENVS

Some envs are need to app process calls

- CIELO_ID: Client ID from Cielo
- CIELO_KEY: Client Key from Cielo

Cielo envs can be generated in [Cielo Sandbox](https://cadastrosandbox.cieloecommerce.cielo.com.br)

- You can use [this](https://github.com/lipejose/store-backend-grpc) project to transpile rest calls to gRPC calls.
- You can use [frontend](https://github.com/lipejose/cyberpunk-grpc-store) store with [proxy](https://github.com/lipejose/grpc-docker-web-proxy) to make gRPC calls.
- Or, you can use any app like insomnia that suport make gRPC calls.
