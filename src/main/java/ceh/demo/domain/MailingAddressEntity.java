package ceh.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ceh.demo.MailingAddress;

@Embeddable
public class MailingAddressEntity implements MailingAddress {

  @Column(name = "street_address")
  private String streetAddress;
  @Column
  private String city;
  @Column
  private String state;
  @Column(name = "zip_code")
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
