package ceh.demo.service;

import java.util.Collection;

import javax.ejb.Local;

@Local
public interface AddressQueryService {

  Collection<AddressDetail> findAllAddresses();
  
}
