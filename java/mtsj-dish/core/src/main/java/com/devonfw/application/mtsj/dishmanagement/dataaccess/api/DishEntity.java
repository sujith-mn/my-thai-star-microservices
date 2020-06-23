package com.devonfw.application.mtsj.dishmanagement.dataaccess.api;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.application.mtsj.dishmanagement.common.api.Dish;
import com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * The {@link com.devonfw.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link Dish}.
 */
@Entity
@Table(name = "Dish")
public class DishEntity extends ApplicationPersistenceEntity implements Dish {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private Long idImage;

  private List<IngredientEntity> extras;

  private List<CategoryEntity> categories;

  /**
   * @return idImage
   */
  @Override
  public Long getIdImage() {
	return idImage;
  }
	
  /**
   * @param idImage new value of {@link #getIdImage}.
   */
  @Override
  public void setIdImage(Long idImage) {
	this.idImage = idImage;
  }


  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return description
   */
  @Override
  public String getDescription() {

    return this.description;
  }

  /**
   * @param description new value of {@link #getDescription}.
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return price
   */
  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getPrice}.
   */
  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  /**
   * @return extras
   */
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "DishIngredient", joinColumns = {
  @javax.persistence.JoinColumn(name = "idDish") }, inverseJoinColumns = @javax.persistence.JoinColumn(name = "idIngredient"))
  public List<IngredientEntity> getExtras() {

    return this.extras;
  }

  /**
   * @param extras new value of {@link #getExtras}.
   */
  public void setExtras(List<IngredientEntity> extras) {

    this.extras = extras;
  }

  /**
   * @return categories
   */
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "DishCategory", joinColumns = {
  @javax.persistence.JoinColumn(name = "idDish") }, inverseJoinColumns = @javax.persistence.JoinColumn(name = "idCategory"))
  public List<CategoryEntity> getCategories() {

    return this.categories;
  }

  /**
   * @param categories new value of {@link #getCategories}.
   */
  public void setCategories(List<CategoryEntity> categories) {

    this.categories = categories;
  }


}
