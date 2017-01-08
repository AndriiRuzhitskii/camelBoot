package com.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
 
@Component
public class Router extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	from("timer://foo?fixedRate=true&period=1000")
    	.setBody(body().append("Time is "))
          .to("log:bar");
    }
    
  @Bean
  String myBean() {
      return "I'm Spring bean!";
  }
    
}
