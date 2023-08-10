package com.itbcafrica.microservices.resource;

import com.itbcafrica.microservices.model.Publisher;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

  @GET
  @Path("{id}")
  public Publisher findPublisherById(@PathParam("id") Long id) {
    return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
  }

  @GET
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Publisher> listAllPublishers() {
    return Publisher.listAll();
  }
}
