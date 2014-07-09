package ceh.demo.domain;

import javax.enterprise.context.ApplicationScoped;

import ceh.demo.Contact;
import ceh.demo.ContactFactory;

@ApplicationScoped
public class ContactFactoryBean implements ContactFactory {

  @Override
  public Contact newContact() {
    return new ContactEntity();
  }

  @Override
  public Contact newContact(Long id, Long version) {
    ContactEntity contact = new ContactEntity();
    contact.setId(id);
    contact.setVersion(version);
    return contact;
  }

}
