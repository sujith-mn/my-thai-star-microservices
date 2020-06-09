package com.devonfw.application.mtsj.ordermanagement.logic.impl;

import java.util.List;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import com.devonfw.application.mtsj.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderCto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderEto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineCto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineEto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineSearchCriteriaTo;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderSearchCriteriaTo;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderedDishesCto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderedDishesSearchCriteriaTo;
import com.devonfw.application.mtsj.ordermanagement.logic.api.Ordermanagement;

/**
 * Implementation of component interface of ordermanagement
 */
@Named
@Transactional
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrdermanagementImpl.class);

  @Override
  public OrderCto findOrder(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<OrderCto> findOrdersByPost(OrderSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderCto> findOrdersByInvitedGuest(Long invitedGuestId) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderCto> findOrdersByBookingToken(String bookingToken) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderCto> findOrders(Long idBooking) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteOrder(Long orderId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public OrderEto saveOrder(OrderCto order) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OrderLineEto findOrderLine(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<OrderLineCto> findOrderLineCtos(OrderLineSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteOrderLine(Long orderLineId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public OrderLineEto saveOrderLine(OrderLineEto orderLine) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<OrderedDishesCto> findOrderedDishes(OrderedDishesSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

}
