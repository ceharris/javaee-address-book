package ceh.demo.web.endpoints;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceh.demo.service.resource.MutableResourceContextService;

@WebFilter("/api/*")
public class ResourceContextFilter implements Filter {

  @Inject
  private MutableResourceContextService resourceContextService;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    doFilter((HttpServletRequest) request, 
        (HttpServletResponse) response, 
        chain);
  }

  private void doFilter(HttpServletRequest request, 
      HttpServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    
    try {
      URI uri = new URI(request.getRequestURL().toString());
      resourceContextService.setRequestUri(uri);
      filterChain.doFilter(request, response);
    }
    catch (URISyntaxException ex) {
      throw new ServletException(ex);
    }
  }
  
}
