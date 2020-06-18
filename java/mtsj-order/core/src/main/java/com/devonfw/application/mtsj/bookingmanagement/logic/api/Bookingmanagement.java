package com.devonfw.application.mtsj.bookingmanagement.logic.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingCto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.InvitedGuestEto;
import com.devonfw.application.mtsj.general.common.impl.config.FeignConfig;

@FeignClient(value = "booking", url = "${feignclient.booking.url}", configuration = FeignConfig.class)
public interface Bookingmanagement {

  /**
   * @param token
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/booking/{token}/", produces = "application/json", consumes = "application/json")
  public BookingCto findBookingByToken(@PathVariable("token") String token);

  /**
   * @param token
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/booking/{token}/", produces = "application/json", consumes = "application/json")
  public InvitedGuestEto findInvitedGuestByToken(@PathVariable("token") String token);

  /**
   * @param bookingId
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/booking/{bookingId}/", produces = "application/json", consumes = "application/json")
  public BookingCto findBooking(@PathVariable("bookingId") Long bookingId);

}
