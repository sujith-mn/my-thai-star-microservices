package com.devonfw.application.mtsj.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class PortalGatewayWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity security) throws Exception {

    security.csrf().disable().logout().disable().formLogin().disable().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().anonymous();

    security.headers().frameOptions().disable();
  }

}
