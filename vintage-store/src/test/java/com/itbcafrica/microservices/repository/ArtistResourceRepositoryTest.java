package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.Artist;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@QuarkusTest
public class ArtistResourceRepositoryTest{
  @Inject ArtistRepository artistRepository;

  @Test
  @Transactional
  public void shouldCreateAndFindAnArtist() throws SQLException{
    long count = artistRepository.count();
    int listAll=artistRepository.listAll().size();
    Assertions.assertEquals(count,listAll);
    Artist artist = new Artist("name", "bio");

    artistRepository.persist(artist);
    Assertions.assertNotNull(artist.id);
    Assertions.assertEquals(count +1,artistRepository.count());
    Artist artistDB = artistRepository.findById(artist.id);
    Assertions.assertNotNull(artistDB);
    artistRepository.deleteById(artist.id);
    Assertions.assertEquals(count ,artistRepository.count());
    Artist artist2 = new Artist("Mame", "bio2");
    artistRepository.persist(artist2);
    List<Artist> artistSorted=artistRepository.listAllArtistSorted();
    Assertions.assertEquals(artistRepository.listAll().size(),artistSorted.size());
  }
}
