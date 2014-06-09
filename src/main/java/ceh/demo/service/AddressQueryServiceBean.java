package ceh.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ceh.demo.Contact;
import ceh.demo.repository.ContactRepository;

@Stateless
public class AddressQueryServiceBean implements AddressQueryService {

  @Inject
  private ContactRepository contactRepository;
  
  @Override
  @Transactional
  public Collection<AddressDetail> findAllAddresses() {
    Collection<AddressDetail> addresses = new ArrayList<>();
    Collection<Contact> contacts = contactRepository.findAll();
    for (Contact contact : contacts) {
      addresses.add(new AddressDetailWrapper(contact));
    }
    return addresses;
  }

}
