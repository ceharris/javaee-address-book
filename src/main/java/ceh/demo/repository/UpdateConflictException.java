package ceh.demo.repository;

public class UpdateConflictException extends RuntimeException {

  private static final long serialVersionUID = 8793284379715032883L;

  public UpdateConflictException(Throwable cause) {
    super(cause);
  }
  
}
