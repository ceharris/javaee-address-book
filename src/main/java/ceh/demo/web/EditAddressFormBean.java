package ceh.demo.web;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.Validate;

import ceh.demo.service.AddressEditor;
import ceh.demo.service.EditAddressService;

@Named
@ConversationScoped
public class EditAddressFormBean implements Serializable {

  private static final long serialVersionUID = 3352788079746104324L;

  private static final String SUCCESS_OUTCOME_ID = "success";

  private static final String NOT_FOUND_OUTCOME_ID = "notFound";

  @Inject
  private EditAddressService editAddressService;
  
  @Inject
  private Conversation conversation;
  
  private Long id;
  private AddressEditor address;

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AddressEditor getAddress() {
    return address;
  }
  
  public String findAddress() {
    Validate.notNull(id);
    address = editAddressService.findAddressById(id);
    if (address == null) {
      return NOT_FOUND_OUTCOME_ID;
    }
    conversation.begin();
    return null;
  }
  
  public String save() {
    editAddressService.save(address);    
    conversation.end();
    return SUCCESS_OUTCOME_ID;
  }
  
}
