package com.devonfw.application.mtsj.ordermanagement.common.api.to;

import java.util.List;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Order
 */
public class OrderCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OrderEto order;

  private List<OrderLineCto> orderLines;

  public OrderEto getOrder() {

    return this.order;
  }

  public void setOrder(OrderEto order) {

    this.order = order;
  }

  public List<OrderLineCto> getOrderLines() {

    return this.orderLines;
  }

  public void setOrderLines(List<OrderLineCto> orderLines) {

    this.orderLines = orderLines;
  }

}
