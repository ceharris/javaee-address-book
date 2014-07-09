package ceh.demo.service.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addresses")
public class AddressResourceCollectionModel {

  @XmlElement(name = "address")
  public List<AddressResourceModel> addresses = new ArrayList<>();
  
  void addAddress(AddressResourceModel address) {
    this.addresses.add(address);
  }
  
}
