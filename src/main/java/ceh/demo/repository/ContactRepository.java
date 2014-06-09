package ceh.demo.repository;

import java.util.Collection;

import ceh.demo.Contact;

public interface ContactRepository {

  void add(Contact contact);

  Collection<Contact> findAll();
  
}
