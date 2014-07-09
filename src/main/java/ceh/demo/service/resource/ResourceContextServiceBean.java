package ceh.demo.service.resource;

import java.net.URI;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResourceContextServiceBean
    implements MutableResourceContextService {

  private URI requestUri;
  
  @Override
  public URI getRequestUri() {
    return requestUri;
  }

  @Override
  public void setRequestUri(URI uri) {
    this.requestUri = uri;
  }

}
