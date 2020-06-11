package com.devonfw.application.mtsj.bookingmanagement.logic.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;

import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingCto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingEto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.BookingSearchCriteriaTo;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.InvitedGuestEto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.InvitedGuestSearchCriteriaTo;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.TableEto;
import com.devonfw.application.mtsj.bookingmanagement.common.api.to.TableSearchCriteriaTo;
import com.devonfw.application.mtsj.bookingmanagement.logic.api.Bookingmanagement;

/**
 * @author sujithna
 *
 */
@Named
@Transactional
public class BookingmanagementImpl implements Bookingmanagement {

  @Override
  public BookingCto findBooking(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BookingCto findBookingByToken(String token) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public InvitedGuestEto findInvitedGuestByToken(String token) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<InvitedGuestEto> findInvitedGuestByBooking(Long bookingId) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<BookingCto> findBookingsByPost(BookingSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<BookingCto> findBookingCtos(BookingSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteBooking(Long bookingId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public BookingEto saveBooking(BookingCto booking) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public InvitedGuestEto findInvitedGuest(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<InvitedGuestEto> findInvitedGuestEtos(InvitedGuestSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteInvitedGuest(Long invitedGuestId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void cancelInvite(String bookingToken) {

    // TODO Auto-generated method stub

  }

  @Override
  public InvitedGuestEto saveInvitedGuest(InvitedGuestEto invitedGuest) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TableEto findTable(Long id) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<TableEto> findTableEtos(TableSearchCriteriaTo criteria) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean deleteTable(Long tableId) {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public TableEto saveTable(TableEto table) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public InvitedGuestEto acceptInvite(String guestToken) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public InvitedGuestEto declineInvite(String guestToken) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String buildToken(String email, String type) throws NoSuchAlgorithmException {

    // TODO Auto-generated method stub
    return null;
  }

}
