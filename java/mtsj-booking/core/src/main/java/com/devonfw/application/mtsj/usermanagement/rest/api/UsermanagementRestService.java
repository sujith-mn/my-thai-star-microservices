package com.devonfw.application.mtsj.usermanagement.rest.api;

import javax.ws.rs.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devonfw.application.mtsj.general.common.impl.config.FeignConfig;
import com.devonfw.application.mtsj.usermanagement.common.api.to.UserEto;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Usermanagement}.
 */
@FeignClient(value = "user", url = "${feignclient.user.url}", configuration = FeignConfig.class)
public interface UsermanagementRestService {

  /**
   * Delegates to {@link Usermanagement#findUser}.
   *
   * @param id the ID of the {@link UserEto}
   * @return the {@link UserEto}
   */

  @RequestMapping(method = RequestMethod.GET, value = "/user/{id}/", produces = "application/json", consumes = "application/json")
  public UserEto getUser(@PathParam("id") long id);

}
