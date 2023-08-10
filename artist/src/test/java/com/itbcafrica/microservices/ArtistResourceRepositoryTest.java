package com.itbcafrica.microservices;

import com.itbcafrica.microservices.model.Artist;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.SQLException;

@QuarkusTest
public class ArtistResourceRepositoryTest {
  @Inject ArtistResourceRepository artistResourceRepository;

  @Test
  public void shouldCreateAndFindAnArtist() throws SQLException{
    Artist artist = new Artist("name", "bio");
    artistResourceRepository.persist(artist);
    Assertions.assertNotNull(artist.getId());

    Artist artistDB = artistResourceRepository.findById(artist.getId());
    Assertions.assertNotNull(artistDB);
  }
}
