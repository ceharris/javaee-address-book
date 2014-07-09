package ceh.demo.service.resource;

import java.net.URI;

public interface MutableResourceContextService 
    extends ResourceContextService {

  void setRequestUri(URI uri);
  
}
