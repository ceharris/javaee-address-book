package ceh.demo.service.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ceh.demo.Contact;
import ceh.demo.ContactFactory;

@ApplicationScoped
public class AddressResourceExtractorBean implements AddressResourceExtractor {

  @Inject
  private ContactFactory contactFactory;
  
  @Override
  public Contact extractContact(AddressResourceModel address) {
    Contact contact = contactFactory.newContact(address.id, address.version);
    contact.setLastName(address.lastName);
    contact.setFirstName(address.firstName);
    contact.getMailingAddress().setStreetAddress(address.streetAddress);
    contact.getMailingAddress().setCity(address.city);
    contact.getMailingAddress().setState(address.state);
    contact.getMailingAddress().setZipCode(address.zipCode);
    return contact;
  }

}
