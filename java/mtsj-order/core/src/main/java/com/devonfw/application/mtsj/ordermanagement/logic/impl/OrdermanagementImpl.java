package com.devonfw.application.mtsj.ordermanagement.logic.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.devonfw.application.mtsj.bookingmanagement.common.api.datatype.BookingType;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingCto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingEto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.InvitedGuestEto;
import com.devonfw.application.mtsj.bookingmanagement.logic.api.Bookingmanagement;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishCto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishEto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.IngredientEto;
import com.devonfw.application.mtsj.dishmanagement.logic.api.Dishmanagement;
import com.devonfw.application.mtsj.general.common.impl.security.ApplicationAccessControlConfig;
import com.devonfw.application.mtsj.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.mtsj.mailservice.logic.api.Mail;
import com.devonfw.application.mtsj.ordermanagement.common.api.OrderLine;
import com.devonfw.application.mtsj.ordermanagement.common.api.exception.CancelNotAllowedException;
import com.devonfw.application.mtsj.ordermanagement.common.api.exception.NoBookingException;
import com.devonfw.application.mtsj.ordermanagement.common.api.exception.NoInviteException;
import com.devonfw.application.mtsj.ordermanagement.common.api.exception.OrderAlreadyExistException;
import com.devonfw.application.mtsj.ordermanagement.common.api.exception.WrongTokenException;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderCto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderEto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineCto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineEto;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderLineSearchCriteriaTo;
import com.devonfw.application.mtsj.ordermanagement.common.api.to.OrderSearchCriteriaTo;
import com.devonfw.application.mtsj.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.application.mtsj.ordermanagement.dataaccess.api.OrderLineEntity;
import com.devonfw.application.mtsj.ordermanagement.dataaccess.api.repo.OrderLineRepository;
import com.devonfw.application.mtsj.ordermanagement.dataaccess.api.repo.OrderRepository;
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

  /**
   * @see #getOrderDao()
   */
  @Inject
  private OrderRepository orderDao;

  /**
   * @see #getOrderLineDao()
   */
  @Inject
  private OrderLineRepository orderLineDao;

  @Inject
  private Bookingmanagement bookingManagement;

  @Inject
  private Dishmanagement dishManagement;

  @Inject
  private Mail mailService;

  @Value("${client.port}")
  private int clientPort;

  @Value("${server.servlet.context-path}")
  private String serverContextPath;

  @Value("${mythaistar.hourslimitcancellation}")
  private int hoursLimit;

  /**
   * The constructor.
   */
  public OrdermanagementImpl() {

    super();
  }

  @Override
  public OrderCto findOrder(Long id) {

    LOG.debug("Get Order with id {} from database.", id);
    OrderEntity entity = getOrderDao().find(id);
    OrderCto cto = new OrderCto();
    // cto.setBooking(getBooking(entity));
    // cto.setHost(getHost(entity));
    cto.setOrderLines(getBeanMapper().mapList(entity.getOrderLines(), OrderLineCto.class));
    // cto.setOrder(getBeanMapper().map(entity, OrderEto.class));
    // cto.setInvitedGuest(getInvitedGuest(entity));
    return cto;
  }

  private InvitedGuestEto getInvitedGuest(OrderEntity entity) {

    InvitedGuestEto invitedGuestEto = new InvitedGuestEto();
    invitedGuestEto.setId(entity.getInvitedGuestId());
    return invitedGuestEto;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_ORDER)
  public Page<OrderCto> findOrdersByPost(OrderSearchCriteriaTo criteria) {

    return findOrderCtos(criteria);
  }

  @Override
  public List<OrderCto> findOrdersByInvitedGuest(Long invitedGuestId) {

    List<OrderCto> ctos = new ArrayList<>();
    List<OrderEntity> orders = getOrderDao().findOrdersByInvitedGuest(invitedGuestId);
    for (OrderEntity order : orders) {
      processOrders(ctos, order);
    }
    return ctos;

  }

  @Override
  public List<OrderCto> findOrdersByBookingToken(String bookingToken) {

    List<OrderCto> ctos = new ArrayList<>();
    /*
     * List<OrderEntity> orders = getOrderDao().findOrdersByBookingToken(bookingToken); for (OrderEntity order : orders)
     * { processOrders(ctos, order); }
     */
    return ctos;

  }

  private List<IngredientEto> getIngredients() {

    return new ArrayList<IngredientEto>();
  }

  @Override
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo criteria) {

    List<OrderCto> ctos = new ArrayList<>();
    Page<OrderCto> pagListTo = null;
    Page<OrderEntity> orders = getOrderDao().findOrders(criteria);
    for (OrderEntity order : orders.getContent()) {
      processOrders(ctos, order);
    }

    if (ctos.size() > 0) {
      Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), ctos.size());
      pagListTo = new PageImpl<>(ctos, pagResultTo, orders.getTotalElements());
    }
    return pagListTo;
  }

  private BookingEto getBooking(OrderEntity order) {

    BookingEto bookingEto = new BookingEto();
    bookingEto.setId(order.getBookingId());
    return bookingEto;
  }

  private BookingEto getHost(OrderEntity order) {

    BookingEto bookingEto = new BookingEto();
    bookingEto.setId(order.getHostId());
    return bookingEto;
  }

  /**
   * @param ctos
   * @param order
   */
  private void processOrders(List<OrderCto> ctos, OrderEntity order) {

    OrderCto cto = new OrderCto();
    // cto.setBooking(getBooking(order));
    // cto.setHost(getHost(order));
    // cto.setInvitedGuest(getInvitedGuest(order));
    cto.setOrder(getBeanMapper().map(order, OrderEto.class));
    cto.setOrderLines(getBeanMapper().mapList(order.getOrderLines(), OrderLineCto.class));
    List<OrderLineCto> orderLinesCto = new ArrayList<>();
    for (OrderLineEntity orderLine : order.getOrderLines()) {
      OrderLineCto orderLineCto = new OrderLineCto();
      orderLineCto.setDish(getDish(orderLine));

      orderLineCto.setExtras(getIngredients());
      orderLineCto.setOrderLine(getBeanMapper().map(orderLine, OrderLineEto.class));
      orderLinesCto.add(orderLineCto);
    }
    cto.setOrderLines(orderLinesCto);
    ctos.add(cto);
  }

  private DishEto getDish(OrderLine orderLine) {

    DishEto dishEto = new DishEto();
    dishEto.setId(orderLine.getDishId());
    return dishEto;
  }

  @Override
  public List<OrderCto> findOrders(Long idBooking) {

    List<OrderCto> ctos = new ArrayList<>();
    List<OrderEntity> orders = getOrderDao().findOrders(idBooking);
    for (OrderEntity order : orders) {
      processOrders(ctos, order);
    }

    return ctos;
  }

  @Override
  public boolean deleteOrder(Long orderId) {

    OrderEntity order = getOrderDao().find(orderId);

    if (!cancellationAllowed(order)) {
      throw new CancelNotAllowedException();
    }
    List<OrderLineEntity> orderLines = getOrderLineDao().findOrderLines(order.getId());

    for (OrderLineEntity orderLine : orderLines) {
      getOrderLineDao().deleteById(orderLine.getId());
    }
    getOrderDao().delete(order);
    LOG.debug("The order with id '{}' has been deleted.", orderId);

    return true;
  }

  @Override
  public OrderEto saveOrder(OrderCto order) {

    Objects.requireNonNull(order, "order");
    List<OrderLineCto> linesCto = order.getOrderLines();
    List<OrderLineEntity> orderLineEntities = new ArrayList<>();
    for (OrderLineCto lineCto : linesCto) {
      OrderLineEntity orderLineEntity = getBeanMapper().map(lineCto, OrderLineEntity.class);

      orderLineEntity.setDishId(lineCto.getOrderLine().getDishId());
      orderLineEntity.setAmount(lineCto.getOrderLine().getAmount());
      orderLineEntity.setComment(lineCto.getOrderLine().getComment());
      orderLineEntities.add(orderLineEntity);
    }

    OrderEntity orderEntity = getBeanMapper().map(order, OrderEntity.class);
    String token ="GET_TOKEN_FROM_BOOKING"; //order.getBooking().getBookingToken();
    // initialize, validate orderEntity here if necessary
    orderEntity = getValidatedOrder(token, orderEntity);
    orderEntity.setOrderLines(orderLineEntities);
    OrderEntity resultOrderEntity = getOrderDao().save(orderEntity);
    LOG.debug("Order with id '{}' has been created.", resultOrderEntity.getId());

    for (OrderLineEntity orderLineEntity : orderLineEntities) {
      orderLineEntity.setOrderId(resultOrderEntity.getId());
      OrderLineEntity resultOrderLine = getOrderLineDao().save(orderLineEntity);
      LOG.info("OrderLine with id '{}' has been created.", resultOrderLine.getId());
    }

    sendOrderConfirmationEmail(token, resultOrderEntity);

    return getBeanMapper().map(resultOrderEntity, OrderEto.class);
  }

  /**
   * Returns the field 'orderDao'.
   *
   * @return the {@link OrderDao} instance.
   */
  public OrderRepository getOrderDao() {

    return this.orderDao;
  }

  @Override
  public OrderLineEto findOrderLine(Long id) {

    LOG.debug("Get OrderLine with id {} from database.", id);
    return getBeanMapper().map(getOrderLineDao().find(id), OrderLineEto.class);
  }

  @Override
  public Page<OrderLineCto> findOrderLineCtos(OrderLineSearchCriteriaTo criteria) {

    Page<OrderLineEntity> orderlines = getOrderLineDao().findOrderLines(criteria);
    List<OrderLineCto> orderLinesCto = new ArrayList<>();
    for (OrderLineEntity orderline : orderlines.getContent()) {
      OrderLineCto orderLineCto = new OrderLineCto();
      orderLineCto.setOrderLine(getBeanMapper().map(this.orderLineDao.find(orderline.getId()), OrderLineEto.class));
      orderLineCto.setExtras(getIngredients());
      orderLinesCto.add(orderLineCto);
    }

    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), orderLinesCto.size());
    Page<OrderLineCto> pagListTo = new PageImpl<>(orderLinesCto, pagResultTo, pagResultTo.getPageSize());
    return pagListTo;
  }

  @Override
  public boolean deleteOrderLine(Long orderLineId) {

    OrderLineEntity orderLine = getOrderLineDao().find(orderLineId);
    getOrderLineDao().delete(orderLine);
    LOG.debug("The orderLine with id '{}' has been deleted.", orderLineId);
    return true;
  }

  @Override
  public OrderLineEto saveOrderLine(OrderLineEto orderLine) {

    Objects.requireNonNull(orderLine, "orderLine");
    OrderLineEntity orderLineEntity = getBeanMapper().map(orderLine, OrderLineEntity.class);

    // initialize, validate orderLineEntity here if necessary
    OrderLineEntity resultEntity = getOrderLineDao().save(orderLineEntity);
    LOG.debug("OrderLine with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, OrderLineEto.class);
  }

  /**
   * Returns the field 'orderLineDao'.
   *
   * @return the {@link OrderLineDao} instance.
   */
  public OrderLineRepository getOrderLineDao() {

    return this.orderLineDao;
  }

  private OrderEntity getValidatedOrder(String token, OrderEntity orderEntity) {

    // BOOKING VALIDATION
    if (getOrderType(token) == BookingType.COMMON) {
      BookingCto booking = getBookingbyToken(token);
      if (booking == null) {
        throw new NoBookingException();
      }
      List<OrderCto> currentOrders = getBookingOrders(booking.getBooking().getId());
      if (!currentOrders.isEmpty()) {
        throw new OrderAlreadyExistException();
      }
      orderEntity.setBookingId(booking.getBooking().getId());

      // GUEST VALIDATION
    } else if (getOrderType(token) == BookingType.INVITED) {

      InvitedGuestEto guest = getInvitedGuestByToken(token);
      if (guest == null) {
        throw new NoInviteException();
      }
      List<OrderCto> currentGuestOrders = getInvitedGuestOrders(guest.getId());
      if (!currentGuestOrders.isEmpty()) {
        throw new OrderAlreadyExistException();
      }
      orderEntity.setBookingId(guest.getBookingId());
      orderEntity.setInvitedGuestId(guest.getId());
    }

    return orderEntity;

  }

  private BookingType getOrderType(String token) throws WrongTokenException {

    if (token.startsWith("CB_")) {
      return BookingType.COMMON;
    } else if (token.startsWith("GB_")) {
      return BookingType.INVITED;
    } else {
      throw new WrongTokenException();
    }
  }

  private BookingCto getBookingbyToken(String token) {

    return this.bookingManagement.findBookingByToken(token);
  }

  private List<OrderCto> getBookingOrders(Long idBooking) {

    return findOrders(idBooking);
  }

  private InvitedGuestEto getInvitedGuestByToken(String token) {

    return this.bookingManagement.findInvitedGuestByToken(token);
  }

  private List<OrderCto> getInvitedGuestOrders(Long idInvitedGuest) {

    return findOrdersByInvitedGuest(idInvitedGuest);
  }

  private void sendOrderConfirmationEmail(String token, OrderEntity order) {

    Objects.requireNonNull(token, "token");
    Objects.requireNonNull(order, "order");
    try {
      String emailTo = getBookingOrGuestEmail(token);
      StringBuilder mailContent = new StringBuilder();

      mailContent.append("MY THAI STAR").append("\n");
      mailContent.append("Hi ").append(emailTo).append("\n");
      mailContent.append("Your order has been created.").append("\n");
      mailContent.append(getContentFormatedWithCost(order)).append("\n");
      mailContent.append("\n").append("Link to cancel order: ");
      String link = "http://localhost:" + this.clientPort + "/booking/cancelOrder/" + order.getId();
      mailContent.append(link);
      this.mailService.sendMail(emailTo, "Order confirmation", mailContent.toString());
    } catch (Exception e) {
      LOG.error("Email not sent. {}", e.getMessage());
    }
  }

  private String getContentFormatedWithCost(OrderEntity order) {

    List<OrderLineEntity> orderLines = this.orderLineDao.findOrderLines(order.getId());

    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    BigDecimal finalPrice = BigDecimal.ZERO;
    for (OrderLineEntity orderLine : orderLines) {
      DishCto dishCto = this.dishManagement.findDish(orderLine.getDishId());
      List<IngredientEto> extras = dishCto.getExtras();
      Set<IngredientEto> set = new HashSet<>();
      set.addAll(extras);
      extras.clear();
      extras.addAll(set);
      // dish name
      BigDecimal linePrice = BigDecimal.ZERO;
      sb.append(dishCto.getDish().getName()).append(", x").append(orderLine.getAmount());
      // dish cost
      BigDecimal dishCost = dishCto.getDish().getPrice().multiply(new BigDecimal(orderLine.getAmount()));
      linePrice = dishCost;
      // dish selected extras
      sb.append(". Extras: ");
      /*
       * for (Ingredient extra : extras) { for (Ingredient selectedExtra : orderLine.getExtras()) { if
       * (extra.getId().equals(selectedExtra.getId())) { sb.append(extra.getName()).append(","); linePrice =
       * linePrice.add(extra.getPrice()); break; } } }
       */

      // dish cost
      sb.append(" ==>").append(". Dish cost: ").append(linePrice.toString());
      sb.append("\n");
      // increase the finalPrice of the order
      finalPrice = finalPrice.add(linePrice);
    }

    return sb.append("Total Order cost: ").append(finalPrice.toString()).toString();
  }

  private String getBookingOrGuestEmail(String token) {

    // Get the Host email
    if (getOrderType(token) == BookingType.COMMON) {
      BookingCto booking = getBookingbyToken(token);
      if (booking == null) {
        throw new NoBookingException();
      }
      return booking.getBooking().getEmail();

      // Get the Guest email
    } else if (getOrderType(token) == BookingType.INVITED) {

      InvitedGuestEto guest = getInvitedGuestByToken(token);
      if (guest == null) {
        throw new NoInviteException();
      }
      return guest.getEmail();
    } else

    {
      return null;
    }
  }

  private boolean cancellationAllowed(OrderEntity order) {

    BookingCto booking = this.bookingManagement.findBooking(order.getBookingId());
    Instant bookingTime = booking.getBooking().getBookingDate();
    long bookingTimeMillis = bookingTime.toEpochMilli();
    long cancellationLimit = bookingTimeMillis - (3600000 * this.hoursLimit);
    long now = Instant.now().toEpochMilli();

    return (now > cancellationLimit) ? false : true;
  }

}
