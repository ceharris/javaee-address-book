package ceh.demo.service;

import javax.ejb.Local;

@Local
public interface AddAddressService {

  AddressDetail newAddress();
  
  void saveAddress(AddressDetail address);
  
}
