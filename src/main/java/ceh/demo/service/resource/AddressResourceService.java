package ceh.demo.service.resource;

import javax.ejb.Local;

@Local
public interface AddressResourceService {

  AddressResourceCollectionModel getAllAddresses();
  
  AddressResourceModel getAddressById(Long id);
  
  Object addAddress(AddressResourceModel address);
    
  AddressResourceModel updateAddress(AddressResourceModel address)
      throws ResourceConflictException, ResourceNotFoundException;
  
  void removeAddress(Long id);
  
}
