package ceh.demo.web;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ceh.demo.service.AddressDetail;
import ceh.demo.service.AddressQueryService;

@Named
@RequestScoped
public class AddressTableBean {

  @Inject
  private AddressQueryService queryService;
  
  private Collection<AddressDetail> addresses;
  
  public Collection<AddressDetail> getAddresses() {
    if (addresses == null) {
      addresses = queryService.findAllAddresses();
    }
    return addresses;
  }
  
}
