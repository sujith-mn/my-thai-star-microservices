package com.devonfw.application.mtsj.general.common.impl.config;

import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;

@Configuration
public class FeignConfig {

  public OkHttpClient client() {

    return new OkHttpClient();
  }

  @Bean
  public RequestInterceptor requestInterceptor() {

    return requestTemplate -> {
      // requestTemplate.header("user", "ajeje");
      // requestTemplate.header("password", "brazof");
      requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
    };
  }

}
