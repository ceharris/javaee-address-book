package ceh.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class EditAddressServiceBean implements EditAddressService {

  @Inject
  private AddressEditorFactory editorFactory;
  
  @Override
  @Transactional
  public AddressEditor findAddressById(Long id) {
    return editorFactory.createEditor(id);
  }

  @Override
  @Transactional
  public void save(AddressEditor editor) {
    editor.save();
  }

}
