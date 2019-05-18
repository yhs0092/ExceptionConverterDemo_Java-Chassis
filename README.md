# Demo of ExceptionToProducerResponseConverter

1. Hello.java shows how to custom error response by `InvocationException`.
2. Once other kind of `Exception` is thrown by business code, you can defined a converter implementing `ExceptionToProducerResponseConverter`  to catch and convert response.
In this case, remember to define a SPI config file for your `ExceptionToProducerResponseConverter` implement class.