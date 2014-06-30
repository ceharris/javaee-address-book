package ceh.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class AddAddressServiceBean implements AddAddressService {

  @Inject
  private AddressEditorFactory editorFactory;
  
  @Override
  public AddressEditor newAddress() {
    return editorFactory.createEditor();
  }

  @Override
  @Transactional
  public void saveAddress(AddressEditor address) {
    address.save();
  }

}
