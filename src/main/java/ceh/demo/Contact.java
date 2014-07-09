package ceh.demo;

public interface Contact {

  Long getId();

  Long getVersion();

  String getFirstName();
  
  void setFirstName(String firstName);
  
  String getLastName();
  
  void setLastName(String lastName);
  
  MailingAddress getMailingAddress();
  
  void setMailingAddress(MailingAddress mailingAddress);
  
  String getPhone();
  
  void setPhone(String phone);
  
}
