package ceh.demo.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ceh.demo.service.AddAddressService;
import ceh.demo.service.AddressDetail;

@Named
@RequestScoped
public class AddAddressFormBean {
  
  private static final String SUCCESS_OUTCOME_ID = "success";

  @Inject
  private AddAddressService addAddressService;
  
  private AddressDetail address;
  
  public AddressDetail getAddress() {
    return address;
  }

  @PostConstruct
  public void init() {
    address = addAddressService.newAddress();
  }
  
  public String save() {
    addAddressService.saveAddress(address);
    return SUCCESS_OUTCOME_ID;
  }
  
}
