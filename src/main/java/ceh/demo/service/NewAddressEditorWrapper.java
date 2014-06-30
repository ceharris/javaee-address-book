package ceh.demo.service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import ceh.demo.repository.ContactRepository;

@Dependent
@NewAddress
public class NewAddressEditorWrapper extends AddressDetailWrapper
    implements AddressEditor {

  private static final long serialVersionUID = -3885887209865914639L;
  
  @Inject
  private ContactRepository contactRepository;
  
  @Override
  public void save() {    
    contactRepository.add(getDelegate());
  }

}
