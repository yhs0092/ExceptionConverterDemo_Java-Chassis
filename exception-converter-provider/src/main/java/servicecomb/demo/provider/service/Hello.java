package servicecomb.demo.provider.service;

import java.util.Date;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestSchema(schemaId = "hello")
@RequestMapping(path = "hello")
public class Hello {

  private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

  @GetMapping(path = "test")
  public String test(@RequestParam(name = "mode") int mode) {
    LOGGER.info("test() is called, mode = [{}]",mode);
    if (0 == mode) {
      return "OK";
    }
    if (1 == mode) {
      LOGGER.info("throw an InvocationException!");
      throw new InvocationException(456, "custom error", new ErrorData("test InvocationException", new Date()));
    }
    LOGGER.info("throw an IllegalArgumentException!");
    throw new IllegalArgumentException("other mode");
  }
}
