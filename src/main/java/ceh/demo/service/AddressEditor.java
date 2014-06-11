package ceh.demo.service;

import ceh.demo.Contact;

public interface AddressEditor extends AddressDetail {

  void setDelegate(Contact contact);
  
  void save();
  
}
