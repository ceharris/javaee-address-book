package ceh.demo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.Validate;

import ceh.demo.Contact;
import ceh.demo.MailingAddress;

@Entity
@Table(name = "contact")
public class ContactEntity implements Contact, Serializable {

  private static final long serialVersionUID = 6256864349725491496L;

  @Id
  @GeneratedValue
  private Long id;
  
  @Version
  private Long version;
  
  @Column(name = "first_name", length = 30)
  private String firstName;
  
  @Column(name = "last_name", length = 30)
  private String lastName;
  
  @OneToOne(optional = false, 
      cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
      fetch = FetchType.LAZY)
  @JoinColumn(name = "mailing_address_id")
  private MailingAddressEntity mailingAddress = new MailingAddressEntity();
  
  @Column
  private String phone;
  
  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public Long getVersion() {
    return version;
  }
  
  public void setVersion(Long version) {
    this.version = version;
  }
  
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
    Validate.isTrue(mailingAddress instanceof MailingAddressEntity);
    this.mailingAddress = (MailingAddressEntity) mailingAddress;
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
