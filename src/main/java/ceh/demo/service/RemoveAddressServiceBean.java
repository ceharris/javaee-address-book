package ceh.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ceh.demo.Contact;
import ceh.demo.repository.ContactRepository;

@Stateless
public class RemoveAddressServiceBean implements RemoveAddressService {

  @Inject
  private ContactRepository contactRepository;
  
  @Override
  @Transactional
  public AddressDetail findAddressById(Long id) {
    Contact contact = contactRepository.findById(id);
    return new AddressDetailWrapper(contact);
  }

  @Override
  @Transactional
  public void removeAddress(AddressDetail detail) {
    contactRepository.remove(((AddressDetailWrapper) detail).getDelegate());
  }

}
