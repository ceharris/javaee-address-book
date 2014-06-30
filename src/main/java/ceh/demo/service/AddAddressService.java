package ceh.demo.service;

import javax.ejb.Local;

@Local
public interface AddAddressService {

  AddressEditor newAddress();
  
  void saveAddress(AddressEditor address);
  
}
