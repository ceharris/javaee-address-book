package ceh.demo.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import ceh.demo.Contact;
import ceh.demo.ContactFactory;
import ceh.demo.repository.ContactRepository;

@ApplicationScoped
public class AddressEditorFactoryBean implements AddressEditorFactory {

  @Inject
  private ContactFactory contactFactory;
  
  @Inject
  private ContactRepository contactRepository;
  
  @Inject
  @NewAddress
  private Instance<AddressEditor> newEditors;

  @Inject
  @ExistingAddress
  private Instance<AddressEditor> existingEditors;
  
  @Override
  public AddressEditor createEditor(Long addressId) {
    Contact contact = contactRepository.findById(addressId);
    if (contact == null) return null;
    AddressEditor editor = existingEditors.get();
    editor.setDelegate(contact);
    return editor;
  }

  @Override
  public AddressEditor createEditor() {
    Contact contact = contactFactory.newContact();
    AddressEditor editor = newEditors.get();
    editor.setDelegate(contact);
    return editor;
  }

}
