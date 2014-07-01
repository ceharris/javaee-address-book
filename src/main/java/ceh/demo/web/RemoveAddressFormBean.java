package ceh.demo.web;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ceh.demo.service.AddressDetail;
import ceh.demo.service.RemoveAddressService;

@Named
@ConversationScoped
public class RemoveAddressFormBean implements Serializable {

  private static final long serialVersionUID = 7976304595946473652L;

  private static final String SUCCESS_OUTCOME_ID = "success";
  
  private static final String CANCEL_OUTCOME_ID = "cancel";

  private static final String NOT_FOUND_OUTCOME_ID = "notFound";

  @Inject
  private RemoveAddressService removeAddressService;

  @Inject
  private Conversation conversation;
  
  private Long id;
  
  private AddressDetail address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AddressDetail getAddress() {
    return address;
  }

  public String findAddress() {
    address = removeAddressService.findAddressById(id);
    if (address == null) {
      return NOT_FOUND_OUTCOME_ID;
    }
    conversation.begin();
    return null;  // stay on the same view (we got here because of viewAction in the view)
  }
  
  public String remove() {
    removeAddressService.removeAddress(address);
    conversation.end();
    return SUCCESS_OUTCOME_ID;
  }
  
  public String cancel() {
    conversation.end();
    return CANCEL_OUTCOME_ID;
  }
  
}
