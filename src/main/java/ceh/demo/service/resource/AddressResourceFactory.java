package ceh.demo.service.resource;

import java.util.Collection;

import ceh.demo.Contact;

public interface AddressResourceFactory {

  AddressResourceModel createResource(Contact contact);

  AddressResourceCollectionModel createResourceCollection(
      Collection<Contact> contacts);
  
}
