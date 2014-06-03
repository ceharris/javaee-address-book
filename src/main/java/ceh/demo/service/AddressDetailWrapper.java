package ceh.demo.service;

import ceh.demo.Contact;

public class AddressDetailWrapper implements AddressDetail {

  private final Contact contact;

  public AddressDetailWrapper(Contact contact) {
    this.contact = contact;
  }

  public String getFirstName() {
    return contact.getFirstName();
  }

  public void setFirstName(String firstName) {
    contact.setFirstName(firstName);
  }

  public String getLastName() {
    return contact.getLastName();
  }

  public void setLastName(String lastName) {
    contact.setLastName(lastName);
  }

  @Override
  public String getStreetAddress() {
    return contact.getMailingAddress().getStreetAddress();
  }

  @Override
  public void setStreetAddress(String streetAddress) {
    contact.getMailingAddress().setStreetAddress(streetAddress);
  }

  @Override
  public String getCity() {
    return contact.getMailingAddress().getCity();
  }

  @Override
  public void setCity(String city) {
    contact.getMailingAddress().setCity(city);
  }

  @Override
  public String getState() {
    return contact.getMailingAddress().getState();
  }

  @Override
  public void setState(String state) {
    contact.getMailingAddress().setState(state);
  }

  @Override
  public String getZipCode() {
    return contact.getMailingAddress().getZipCode();
  }

  @Override
  public void setZipCode(String zipCode) {
    contact.getMailingAddress().setZipCode(zipCode);
  }
  
}
