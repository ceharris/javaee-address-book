package ceh.demo;

public interface Contact {

  Object getId();
  
  String getFirstName();
  
  void setFirstName(String firstName);
  
  String getLastName();
  
  void setLastName(String lastName);
  
  MailingAddress getMailingAddress();
  
  void setMailingAddress(MailingAddress mailingAddress);
  
  String getPhone();
  
  void setPhone(String phone);
  
}
