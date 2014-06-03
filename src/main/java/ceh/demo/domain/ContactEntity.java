package ceh.demo.domain;

import ceh.demo.Contact;
import ceh.demo.MailingAddress;

public class ContactEntity implements Contact {

  private String firstName;
  private String lastName;
  private MailingAddress mailingAddress = new MailingAddressEntity();
  private String phone;

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public MailingAddress getMailingAddress() {
    return mailingAddress;
  }

  @Override
  public void setMailingAddress(MailingAddress mailingAddress) {
    this.mailingAddress = mailingAddress;
  }

  @Override
  public String getPhone() {
    return phone;
  }

  @Override
  public void setPhone(String phone) {
    this.phone = phone;
  }

}
