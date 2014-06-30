package ceh.demo.service;

public interface AddressEditorFactory {

  AddressEditor createEditor();
  
  AddressEditor createEditor(Long addressId);
  
}
