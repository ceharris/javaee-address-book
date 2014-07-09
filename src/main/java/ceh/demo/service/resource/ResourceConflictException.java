package ceh.demo.service.resource;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ResourceConflictException extends Exception {

  private static final long serialVersionUID = -805050744926824419L;

}
