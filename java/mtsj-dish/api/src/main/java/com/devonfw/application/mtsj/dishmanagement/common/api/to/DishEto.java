package com.devonfw.application.mtsj.dishmanagement.common.api.to;

import java.math.BigDecimal;

import com.devonfw.application.mtsj.dishmanagement.common.api.Dish;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Dish
 */
public class DishEto extends AbstractEto implements Dish {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private Long idImage;

@Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getDescription() {

    return this.description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  public Long getIdImage() {
	return idImage;
}

public void setIdImage(Long idImage) {
	this.idImage = idImage;
}


  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    result = prime * result + ((this.idImage == null) ? 0 : this.idImage.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    DishEto other = (DishEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    if (this.idImage == null) {
      if (other.idImage != null) {
        return false;
      }
    } else if (!this.idImage.equals(other.idImage)) {
      return false;
    }

    return true;
  }
}
