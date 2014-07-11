package ceh.demo.web.endpoints;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import ceh.demo.service.resource.AddressResourceCollectionModel;
import ceh.demo.service.resource.AddressResourceModel;
import ceh.demo.service.resource.AddressResourceService;
import ceh.demo.service.resource.ResourceConflictException;
import ceh.demo.service.resource.ResourceNotFoundException;

@Path("/addresses")
public class AddressResourceEndpoint {
  
  @Inject
  private AddressResourceService service;
    
  @GET
  @Path("/")
  public AddressResourceCollectionModel getAllAddresses() {
    return service.getAllAddresses();
  }

  @POST
  @Path("/")
  public Response addAddress(@Context UriInfo uri, 
      AddressResourceModel address) {
    address.id = null;
    address.version = null;
    Object id = service.addAddress(address);
    UriBuilder uriBuilder = uri.getBaseUriBuilder();
    URI newUri = uriBuilder.path(uri.getPath()).path("{id}").build(id);
    return Response.created(newUri).build();
  }
  
  @GET
  @Path("/{id}")
  public Response getAddressById(@PathParam("id") Long id) {
    AddressResourceModel address = service.getAddressById(id);
    if (address == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(address).build();
  }
  
  @PUT
  @Path("/{id}")
  public Response updateAddress(@PathParam("id") Long id,
      AddressResourceModel address) {
    try {
      address.id = id;
      return Response.ok(service.updateAddress(address)).build();
    }
    catch (ResourceConflictException ex) {
      return Response.status(Response.Status.CONFLICT).build();
    }
    catch (ResourceNotFoundException ex) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }
  
  @DELETE
  @Path("/{id}")
  public Response deleteAddress(@PathParam("id") Long id) {
    service.removeAddress(id);
    return Response.ok().build();
  }
  
}
