package com.devonfw.application.mtsj.dishmanagement.logic.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishCto;
import com.devonfw.application.mtsj.general.common.impl.config.FeignConfig;

@FeignClient(value = "dish", url = "${feignclient.dish.url}", configuration = FeignConfig.class)
public interface Dishmanagement {

  @RequestMapping(method = RequestMethod.GET, value = "/dish/{id}/", produces = "application/json", consumes = "application/json")
  public DishCto findDish(Long dishId);

}
