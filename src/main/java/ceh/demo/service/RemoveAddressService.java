package ceh.demo.service;

import javax.ejb.Local;

@Local
public interface RemoveAddressService {

  AddressDetail findAddressById(Long id);
  
  void removeAddress(AddressDetail detail);
  
}
