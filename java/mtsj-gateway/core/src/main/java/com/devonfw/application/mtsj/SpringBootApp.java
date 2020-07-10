package com.devonfw.application.mtsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class PortalGatewayApplication {
  public static void main(String[] args) {

    SpringApplication.run(PortalGatewayApplication.class, args);
  }
}
