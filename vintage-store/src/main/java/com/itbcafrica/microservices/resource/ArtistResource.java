package com.itbcafrica.microservices.resource;

import com.itbcafrica.microservices.model.Artist;
import com.itbcafrica.microservices.repository.ArtistRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {
  @Inject ArtistRepository artistRepository;

  @GET
  @Path("{id}")
  public Artist findArtistById(@PathParam("id") Long id) {
    return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
  }

  @GET
  public List<Artist> listAllArtists() {
    return artistRepository.listAll();
  }

  @POST
  @Transactional
  public Response persistArtist(Artist artist, @Context UriInfo uriInfo) {
    artistRepository.persist(artist);
    UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.id));
    return Response.created(builder.build()).build();
  }

  @DELETE
  @Transactional
  @Path("{id}")
  public void deleteArtist(@PathParam("id") Long id) {
    artistRepository.deleteById(id);
  }
}
