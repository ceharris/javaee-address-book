package ceh.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import ceh.demo.MailingAddress;

@Entity
@Table(name = "mailing_address")
public class MailingAddressEntity implements MailingAddress {

  @Id
  @GeneratedValue
  private Long id;
  
  @Version
  private Long version;
  
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
