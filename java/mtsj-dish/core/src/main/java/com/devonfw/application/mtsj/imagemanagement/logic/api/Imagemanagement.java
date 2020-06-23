package com.devonfw.application.mtsj.imagemanagement.logic.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devonfw.application.mtsj.general.service.impl.config.FeignConfig;
import com.devonfw.application.mtsj.imagemanagement.common.api.to.ImageEto;
import com.devonfw.application.mtsj.imagemanagement.common.api.to.ImageSearchCriteriaTo;

/**
 * Interface for Imagemanagement component.
 */
@FeignClient(value = "image", url = "${feignclient.image.url}", configuration = FeignConfig.class)
public interface Imagemanagement {

  /**
   * Returns a Image by its id 'id'.
   *
   * @param id The id 'id' of the Image.
   * @return The {@link ImageEto} with id 'id'
   */
  @RequestMapping(method = RequestMethod.GET, value = "/image/{id}/", produces = "application/json", consumes = "application/json")
  ImageEto findImage(@PathVariable("id") Long id);

  /**
   * Returns a paginated list of Images matching the search criteria.
   *
   * @param criteria the {@link ImageSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ImageEto}s.
   */
  @RequestMapping(method = RequestMethod.POST, value = "/image/search/", produces = "application/json", consumes = "application/json")
  Page<ImageEto> findImageEtos(ImageSearchCriteriaTo criteria);

  /**
   * Deletes a image from the database by its id 'imageId'.
   *
   * @param imageId Id of the image to delete
   * @return boolean <code>true</code> if the image can be deleted, <code>false</code> otherwise
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/image/{id}/", produces = "application/json", consumes = "application/json")  
  boolean deleteImage(@PathVariable("id") Long imageId);

  /**
   * Saves a image and store it in the database.
   *
   * @param image the {@link ImageEto} to create.
   * @return the new {@link ImageEto} that has been saved with ID and version.
   */
  @RequestMapping(method = RequestMethod.POST, value = "/image/", produces = "application/json", consumes = "application/json")  
  ImageEto saveImage(ImageEto image);

}