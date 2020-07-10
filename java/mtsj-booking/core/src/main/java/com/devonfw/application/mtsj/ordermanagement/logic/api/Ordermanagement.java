package com.devonfw.application.mtsj.ordermanagement.logic.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devonfw.application.mtsj.general.common.impl.config.FeignConfig;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderCto;

@FeignClient(value = "order", url = "${feignclient.order.url}", configuration = FeignConfig.class)
public interface Ordermanagement {

  /**
   * @param id
   * @return
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/order/{id}/", produces = "application/json", consumes = "application/json")
  boolean deleteOrder(@PathVariable("id") Long id);

  /**
   * @param bookingId
   * @return
   */

  @RequestMapping(method = RequestMethod.GET, value = "/orders/{bookingId}", produces = "application/json", consumes = "application/json")
  List<OrderCto> findOrders(@PathVariable("bookingId") Long bookingId);

  /**
   * @param bookingToken
   * @return
   */
  // TODO not working
  @RequestMapping(method = RequestMethod.GET, value = "/order/{id}", produces = "application/json", consumes = "application/json")
  List<OrderCto> findOrdersByBookingToken(@PathVariable("id") String bookingToken);

  /**
   * @param id
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/order/{id}", produces = "application/json", consumes = "application/json")
  List<OrderCto> findOrdersByInvitedGuest(@PathVariable("id") Long id);

}