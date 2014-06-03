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

}
