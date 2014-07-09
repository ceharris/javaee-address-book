package ceh.demo.service.resource;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import ceh.demo.Contact;

@ApplicationScoped
public class AddressResourceFactoryBean implements AddressResourceFactory {

  @Override
  public AddressResourceModel createResource(Contact contact) {
    AddressResourceModel model = new AddressResourceModel();
    model.id = contact.getId();
    model.version = contact.getVersion();
    model.lastName = contact.getLastName();
    model.firstName = contact.getFirstName();
    model.streetAddress = contact.getMailingAddress().getStreetAddress();
    model.city = contact.getMailingAddress().getCity();
    model.state = contact.getMailingAddress().getState();
    model.zipCode = contact.getMailingAddress().getZipCode();
    return model;  
  }

  @Override
  public AddressResourceCollectionModel createResourceCollection(
      Collection<Contact> contacts) {
    AddressResourceCollectionModel model = new AddressResourceCollectionModel();
    for (Contact contact : contacts) {
      model.addAddress(createResource(contact));
    }
    return model;
  }

}
