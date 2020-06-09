package com.devonfw.application.mtsj.ordermanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.mtsj.ordermanagement.common.api.OrderedDishes;

/**
 * {@link ApplicationPersistenceEntity Entity} that represents a single {@link OrderedDishesPerDay} of an
 * {@link OrderedDishesPerDay}.
 */
@Entity
@Immutable
@Table(name = "OrderedDishesPerDay")
public class OrderedDishesPerDayEntity extends ApplicationPersistenceEntity implements OrderedDishes {

  private static final long serialVersionUID = 1L;

  private Long idDish;

  private Integer amount;

  private Double temperature;

  private String designation;

  private Timestamp bookingdate;

  /**
   * @return amount
   */
  @Override
  public Integer getAmount() {

    return this.amount;
  }

  /**
   * @param number of ordered dished per day {@link #getAmount}.
   */
  @Override
  public void setAmount(Integer amount) {

    this.amount = amount;
  }

  /**
   * @return temperature
   */
  @Override
  public Double getTemperature() {

    return this.temperature;
  }

  /**
   * @param temperature new value of {@link #getTemperature}.
   */
  @Override
  public void setTemperature(Double temperature) {

    this.temperature = temperature;
  }

  /**
   * @return designation
   */
  public String getDesignation() {

    return this.designation;
  }

  /**
   * @param designation of holiday or event {@link #getDesignation}.
   */
  public void setDesignation(String designation) {

    this.designation = designation;
  }

  /**
   * @return bookingdate
   */
  @Override
  public Timestamp getBookingdate() {

    return this.bookingdate;
  }

  /**
   * @param bookingdate new value of {@link #getBookingdate}.
   */
  @Override
  public void setBookingdate(Timestamp bookingdate) {

    this.bookingdate = bookingdate;
  }

  /**
   * @return idDish
   */
  public Long getIdDish() {

    return this.idDish;
  }

  /**
   * @param idDish new value of {@link #getidDish}.
   */
  public void setIdDish(Long idDish) {

    this.idDish = idDish;
  }

}
