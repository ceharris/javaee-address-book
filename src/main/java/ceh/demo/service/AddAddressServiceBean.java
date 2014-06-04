package ceh.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;

import ceh.demo.ContactFactory;
import ceh.demo.repository.ContactRepository;

@Stateless
public class AddAddressServiceBean implements AddAddressService {

  @Inject
  private ContactFactory contactFactory;
  
  @Inject
  private ContactRepository contactRepository;
  
  @Override
  public AddressDetail newAddress() {
    return new AddressDetailWrapper(contactFactory.newContact());
  }

  @Override
  @Transactional
  public void saveAddress(AddressDetail address) {
    Validate.isTrue(address instanceof AddressDetailWrapper, 
        "address must be an AddressDetailWrapper");
    contactRepository.add(((AddressDetailWrapper) address).getDelegate());
  }

}
