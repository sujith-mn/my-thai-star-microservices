package com.devonfw.application.mtsj.dishmanagement.logic.impl;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;

import com.devonfw.application.mtsj.dishmanagement.common.api.to.CategoryEto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.CategorySearchCriteriaTo;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishCto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishEto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.DishSearchCriteriaTo;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.IngredientEto;
import com.devonfw.application.mtsj.dishmanagement.common.api.to.IngredientSearchCriteriaTo;
import com.devonfw.application.mtsj.dishmanagement.logic.api.Dishmanagement;

/**
 * @author sujithna
 *
 */
@Named
@Transactional
public class DishmanagementImpl implements Dishmanagement {

  @Override
  public CategoryEto findCategory(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<CategoryEto> findCategoryEtos(CategorySearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteCategory(Long categoryId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public CategoryEto saveCategory(CategoryEto category) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public DishCto findDish(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<DishCto> findDishCtos(DishSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteDish(Long dishId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public DishEto saveDish(DishEto dish) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IngredientEto findIngredient(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<IngredientEto> findIngredientEtos(IngredientSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteIngredient(Long ingredientId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public IngredientEto saveIngredient(IngredientEto ingredient) {

    // TODO Auto-generated method stub
    return null;
  }

}
