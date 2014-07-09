package ceh.demo;

public interface ContactFactory {

  Contact newContact();
  
  Contact newContact(Long id, Long version);
  
}
