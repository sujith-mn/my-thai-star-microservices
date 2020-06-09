package com.devonfw.application.mtsj.ordermanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.mtsj.ordermanagement.common.api.Order;

/**
 * The {@link com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link Order}.
 */
@Entity
@Table(name = "Orders")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private static final long serialVersionUID = 1L;

  private Long idInvitedGuest;

  private Long idBooking;

  private Long idHost;

  private List<OrderLineEntity> orderLines;

  /**
   * @return idInvitedGuest
   */
  public Long getIdInvitedGuest() {

    return this.idInvitedGuest;
  }

  /**
   * @param idInvitedGuest new value of {@link #getidInvitedGuest}.
   */
  public void setIdInvitedGuest(Long idInvitedGuest) {

    this.idInvitedGuest = idInvitedGuest;
  }

  /**
   * @return idBooking
   */
  public Long getIdBooking() {

    return this.idBooking;
  }

  /**
   * @param idBooking new value of {@link #getidBooking}.
   */
  public void setIdBooking(Long idBooking) {

    this.idBooking = idBooking;
  }

  /**
   * @return idHost
   */
  public Long getIdHost() {

    return this.idHost;
  }

  /**
   * @param idHost new value of {@link #getidHost}.
   */
  public void setIdHost(Long idHost) {

    this.idHost = idHost;
  }

  /**
   * @return orderLines
   */
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  public List<OrderLineEntity> getOrderLines() {

    return this.orderLines;
  }

  /**
   * @param orderLines new value of {@link #getorderLines}.
   */
  public void setOrderLines(List<OrderLineEntity> orderLines) {

    this.orderLines = orderLines;
  }

  @Override
  @Transient
  public Long getBookingId() {

    return this.idBooking;
  }

  @Override
  public void setBookingId(Long bookingId) {

    this.idBooking = bookingId;
  }

  @Override
  @Transient
  public Long getInvitedGuestId() {

    return this.idInvitedGuest;
  }

  @Override
  public void setInvitedGuestId(Long invitedGuestId) {

    this.idInvitedGuest = invitedGuestId;
  }

  @Override
  @Transient
  public Long getHostId() {

    return this.idHost;
  }

  @Override
  public void setHostId(Long hostId) {

    this.idHost = hostId;

  }

}
