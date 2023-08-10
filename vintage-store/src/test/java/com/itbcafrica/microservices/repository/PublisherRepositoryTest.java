package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.Publisher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

@QuarkusTest
public class PublisherRepositoryTest {

  @Test
  @Transactional
  public void shouldCreateAndFindAnCustomer() {
    long count = Publisher.count();
    long listAll = Publisher.findAll().count();
    Assertions.assertEquals(count, listAll);
    Publisher publisher = new Publisher("name");
    Publisher.persist(publisher);
    Assertions.assertEquals(count + 1, Publisher.count());
    Assertions.assertNotNull(publisher);
    Publisher.findById(publisher.id);
    String actual=Publisher.findByName("name").get().name;
    Assertions.assertEquals("name", actual);
    Assertions.assertTrue(Publisher.findContainName("name").size()>=1);
    Assertions.assertEquals("name", publisher.name);
    Publisher.deleteById(publisher.id);
    Assertions.assertEquals(count, Publisher.count());


  }
}
