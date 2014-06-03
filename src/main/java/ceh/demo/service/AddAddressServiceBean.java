package ceh.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ceh.demo.ContactFactory;

@Stateless
public class AddAddressServiceBean implements AddAddressService {

  @Inject
  private ContactFactory contactFactory;
  
  @Override
  public AddressDetail newAddress() {
    return new AddressDetailWrapper(contactFactory.newContact());
  }

  @Override
  public void saveAddress(AddressDetail address) {
    System.out.println("first name: " + address.getFirstName());
  }

}
