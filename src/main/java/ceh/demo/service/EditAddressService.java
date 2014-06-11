package ceh.demo.service;

import javax.ejb.Local;

@Local
public interface EditAddressService {

  AddressEditor findAddressById(Long id);
  
  void save(AddressEditor editor);
  
}
