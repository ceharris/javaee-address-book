package ceh.demo.service.resource;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "address")
public class AddressResourceModel {

  @XmlAttribute
  public Long id;
  
  @XmlAttribute
  public Long version;
  
  @XmlAttribute
  public String uri;
  
  @XmlElement
  public String lastName;
  
  @XmlElement
  public String firstName;
  
  @XmlElement
  public String streetAddress;
  
  @XmlElement
  public String city;
  
  @XmlElement
  public String state;
  
  @XmlElement
  public String zipCode;
  
}
