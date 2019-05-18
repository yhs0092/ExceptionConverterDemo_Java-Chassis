package servicecomb.demo.provider.exception;

import java.util.Date;

import org.apache.servicecomb.swagger.invocation.Response;
import org.apache.servicecomb.swagger.invocation.SwaggerInvocation;
import org.apache.servicecomb.swagger.invocation.exception.ExceptionToProducerResponseConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import servicecomb.demo.provider.service.ErrorData;

public class DemoExceptionConverter implements ExceptionToProducerResponseConverter<IllegalArgumentException> {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoExceptionConverter.class);

  @Override
  public Class<IllegalArgumentException> getExceptionClass() {
    return IllegalArgumentException.class;
  }

  @Override
  public Response convert(SwaggerInvocation swaggerInvocation, IllegalArgumentException e) {
    LOGGER.info("Here we catch an IllegalArgumentException and convert it!");
    return Response.create(460, "Custom Error 2", new ErrorData(e.getMessage(), new Date()));
  }
}
