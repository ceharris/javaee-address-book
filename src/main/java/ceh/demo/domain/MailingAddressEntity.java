package ceh.demo.domain;

import ceh.demo.MailingAddress;

public class MailingAddressEntity implements MailingAddress {

  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;

  @Override
  public String getStreetAddress() {
    return streetAddress;
  }

  @Override
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  @Override
  public String getCity() {
    return city;
  }

  @Override
  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String getState() {
    return state;
  }

  @Override
  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String getZipCode() {
    return zipCode;
  }

  @Override
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

}
