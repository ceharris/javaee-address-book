package ceh.demo.service.resource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ceh.demo.Contact;
import ceh.demo.repository.ContactRepository;
import ceh.demo.repository.EntityNotFoundException;
import ceh.demo.repository.UpdateConflictException;

@Stateless
public class AddressResourceServiceBean implements AddressResourceService {

  @Inject
  private ContactRepository contactRepository;

  @Inject
  private AddressResourceFactory addressResourceFactory;

  @Inject
  private AddressResourceExtractor addressResourceExtractor;

  @Override
  @Transactional
  public AddressResourceCollectionModel getAllAddresses() {
    return addressResourceFactory.createResourceCollection(contactRepository
        .findAll());
  }

  @Override
  @Transactional
  public AddressResourceModel getAddressById(Long id) {
    Contact contact = contactRepository.findById(id);
    if (contact == null)
      return null;
    return addressResourceFactory.createResource(contact);
  }

  @Override
  @Transactional
  public Object addAddress(AddressResourceModel address) {
    Contact contact = addressResourceExtractor.extractContact(address);
    contactRepository.add(contact);
    contactRepository.flush();
    return contact.getId();
  }

  @Override
  @Transactional
  public AddressResourceModel updateAddress(AddressResourceModel address) 
      throws ResourceConflictException, ResourceNotFoundException {
    try {
      Contact contact =
          contactRepository.update(addressResourceExtractor
              .extractContact(address));
      contactRepository.flush();
      AddressResourceModel updatedAddress =
          addressResourceFactory.createResource(contact);
      return updatedAddress;
    }
    catch (EntityNotFoundException ex) {
      throw new ResourceNotFoundException();
    }
    catch (UpdateConflictException ex) {
      throw new ResourceConflictException();
    }
  }

  @Override
  @Transactional
  public void removeAddress(Long id) {
    Contact contact = contactRepository.findById(id);
    if (contact == null)
      return;
    contactRepository.remove(contact);
  }

}
