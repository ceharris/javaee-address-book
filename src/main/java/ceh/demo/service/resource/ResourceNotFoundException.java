package ceh.demo.service.resource;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ResourceNotFoundException extends Exception {

  private static final long serialVersionUID = -1646443097927433020L;

}
