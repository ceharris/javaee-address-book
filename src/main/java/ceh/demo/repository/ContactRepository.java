package ceh.demo.repository;

import java.util.Collection;

import ceh.demo.Contact;

public interface ContactRepository {

  void add(Contact contact);

  Contact update(Contact contact) throws UpdateConflictException;
  
  void remove(Contact contact);

  Collection<Contact> findAll();
  
  Contact findById(Long id);
  
  void flush();
  
}
