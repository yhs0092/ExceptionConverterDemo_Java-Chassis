package servicecomb.demo.consumer.service;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RestSchema(schemaId = "consumer")
@RequestMapping("consumer")
public class Consumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  private RestTemplate restTemplate = RestTemplateBuilder.create();

  @GetMapping("test")
  public String test(@RequestParam(name = "mode") int mode) {
    String response = null;
    try {
      response = restTemplate.getForObject("cse://provider/hello/test?mode=" + mode, String.class);
    } catch (InvocationException e) {
      LOGGER.info("get an InvocationException", e);
      throw e;
    }
    return response;
  }
}
