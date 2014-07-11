package ceh.demo.web.endpoints;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Provider
@Produces("application/xml")
public class FormattedXmlMessageBodyWriter
    implements MessageBodyWriter<Object> {

  private final Map<Class, JAXBContext> contextCache = 
      new WeakHashMap<>();
      
  @Override
  public boolean isWriteable(Class<?> type, Type genericType,
      Annotation[] annotations, MediaType mediaType) {
    if (contextCache.containsKey(type)) {
      return true;
    }
    try {
      JAXBContext context = JAXBContext.newInstance(type);
      contextCache.put(type, context);
      return true;
    }
    catch (JAXBException ex) {
      return false;
    }
  }

  @Override
  public long getSize(Object t, Class<?> type, Type genericType,
      Annotation[] annotations, MediaType mediaType) {
    return -1;
  }

  @Override
  public void writeTo(Object t, Class<?> type, Type genericType,
      Annotation[] annotations, MediaType mediaType,
      MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {
    JAXBContext context = contextCache.get(type);
    if (context == null) {
      throw new UnsupportedOperationException("cannot write type " 
          + type.getName());
    }
 
    try {
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(t, entityStream);
    }
    catch (JAXBException ex) {
      throw new InternalServerErrorException(ex);
    }
  }

}
