package com.devonfw.application.mtsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringBootApp {
  public static void main(String[] args) {

    SpringApplication.run(SpringBootApp.class, args);
  }
}
