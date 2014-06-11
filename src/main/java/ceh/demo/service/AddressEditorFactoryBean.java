package ceh.demo.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import ceh.demo.Contact;
import ceh.demo.repository.ContactRepository;

@ApplicationScoped
public class AddressEditorFactoryBean implements AddressEditorFactory {

  @Inject
  private ContactRepository contactRepository;
  
  @Inject
  private Instance<AddressEditor> editors;
  
  @Override
  public AddressEditor createEditor(Long addressId) {
    Contact contact = contactRepository.findById(addressId);
    if (contact == null) return null;
    AddressEditor editor = editors.get();
    editor.setDelegate(contact);
    return editor;
  }

}
