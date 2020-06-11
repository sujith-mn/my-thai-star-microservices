package com.devonfw.application.mtsj.bookingmanagement.dataaccess.api;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import com.devonfw.application.mtsj.bookingmanagement.common.api.Booking;
import com.devonfw.application.mtsj.bookingmanagement.common.api.datatype.BookingType;
import com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "Booking")
public class BookingEntity extends ApplicationPersistenceEntity implements Booking {

  private String name;

  private String bookingToken;

  private String comment;

  private Instant bookingDate;

  private Instant expirationDate;

  private Instant creationDate;

  private String email;

  private Boolean canceled;

  private BookingType bookingType;

  private TableEntity table;

  private Long idOrder;

  private Long idUser;

  private List<InvitedGuestEntity> invitedGuests;

  // private List<OrderEntity> orders;

  @Min(value = 1, message = "Assistants must be greater than 0")
  @Digits(integer = 2, fraction = 0)
  private Integer assistants;

  private static final long serialVersionUID = 1L;

  public BookingEntity() {

    super();
    this.canceled = false;
  }

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return bookingToken
   */
  @Override
  public String getBookingToken() {

    return this.bookingToken;
  }

  /**
   * @param bookingToken new value of {@link #getbookingToken}.
   */
  @Override
  public void setBookingToken(String bookingToken) {

    this.bookingToken = bookingToken;
  }

  /**
   * @return comments
   */
  @Override
  public String getComment() {

    return this.comment;
  }

  /**
   * @param comments new value of {@link #getcomments}.
   */
  @Override
  public void setComment(String comments) {

    this.comment = comments;
  }

  /**
   * @return bookingDate
   */
  @Override
  public Instant getBookingDate() {

    return this.bookingDate;
  }

  /**
   * @param bookingDate new value of {@link #getbookingDate}.
   */
  @Override
  public void setBookingDate(Instant bookingDate) {

    this.bookingDate = bookingDate;
  }

  /**
   * @return expirationDate
   */
  @Override
  public Instant getExpirationDate() {

    return this.expirationDate;
  }

  /**
   * @param expirationDate new value of {@link #getexpirationDate}.
   */
  @Override
  public void setExpirationDate(Instant expirationDate) {

    this.expirationDate = expirationDate;
  }

  /**
   * @return creationDate
   */
  @Override
  public Instant getCreationDate() {

    return this.creationDate;
  }

  /**
   * @param creationDate new value of {@link #getcreationDate}.
   */
  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  /**
   * @return canceled
   */
  @Override
  public Boolean getCanceled() {

    return this.canceled;
  }

  /**
   * @param canceled new value of {@link #getcanceled}.
   */
  @Override
  public void setCanceled(Boolean canceled) {

    this.canceled = canceled;
  }

  /**
   * @return table
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTable")
  public TableEntity getTable() {

    return this.table;
  }

  /**
   * @param table new value of {@link #gettable}.
   */
  public void setTable(TableEntity table) {

    this.table = table;
  }

  /**
   * @return invitedGuests
   */
  @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
  public List<InvitedGuestEntity> getInvitedGuests() {

    return this.invitedGuests;
  }

  /**
   * @param invitedGuests new value of {@link #getinvitedGuests}.
   */
  public void setInvitedGuests(List<InvitedGuestEntity> invitedGuests) {

    this.invitedGuests = invitedGuests;
  }

  /**
   * @return type
   */
  @Override
  public BookingType getBookingType() {

    return this.bookingType;
  }

  /**
   * @param type new value of {@link #gettype}.
   */
  @Override
  public void setBookingType(BookingType bookingType) {

    this.bookingType = bookingType;
  }

  @Override
  public String getEmail() {

    return this.email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;

  }

  @Override
  @Transient
  public Long getTableId() {

    if (this.table == null) {
      return null;
    }
    return this.table.getId();
  }

  @Override
  public void setTableId(Long tableId) {

    if (tableId == null) {
      this.table = null;
    } else {
      TableEntity tableEntity = new TableEntity();
      tableEntity.setId(tableId);
      this.table = tableEntity;
    }
  }

  @Override
  @Transient
  public Long getOrderId() {

    return this.idOrder;
  }

  @Override
  public void setOrderId(Long orderId) {

    this.idOrder = orderId;
  }

  /**
   * @return orders
   */
  /*
   * @OneToMany(mappedBy = "booking", fetch = FetchType.EAGER) public List<OrderEntity> getOrders() {
   *
   * return this.orders; }
   *
   *//**
      * @param orders new value of {@link #getorders}.
      *//*
         * public void setOrders(List<OrderEntity> orders) {
         *
         * this.orders = orders; }
         */

  /**
   * @return assistants
   */
  @Override
  public Integer getAssistants() {

    return this.assistants;
  }

  /**
   * @param assistants new value of {@link #getassistants}.
   */
  @Override
  public void setAssistants(Integer assistants) {

    this.assistants = assistants;
  }

  @Override
  @Transient
  public Long getUserId() {

    return this.idUser;
  }

  @Override
  public void setUserId(Long userId) {

    this.idUser = userId;
  }

}
