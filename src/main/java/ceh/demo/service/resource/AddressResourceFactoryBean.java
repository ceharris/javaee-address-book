package ceh.demo.service.resource;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;

import ceh.demo.Contact;

@ApplicationScoped
public class AddressResourceFactoryBean implements AddressResourceFactory {

  @Inject
  private ResourceContextService resourceContextService;
  
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
      AddressResourceModel address = createResource(contact);
      address.uri = UriBuilder.fromUri(resourceContextService.getRequestUri())
          .path("{id}").build(address.id).toASCIIString();
      model.addAddress(address);
    }
    return model;
  }

}
