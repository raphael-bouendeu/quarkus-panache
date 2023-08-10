package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.*;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@QuarkusTest
public class PurchaseOrderRepositoryTest {
  @Inject CustomerRepository customerRepository;

  @Test
  @Transactional
  public void shouldCreateAndFindAnPurchaseOrder() {
    // creates an Artist
    Artist artist = new Artist("artist name", "artist bio");
    // create an Publisher
    Publisher publisher = new Publisher("publischer name");
    // create a Book
    Book book = new Book();
    book.title = "title of Book";
    book.nbOfPages = 500;
    book.isbn = "isbn";
    book.price = new BigDecimal(10);
    book.language = Language.ENGLISH;
    // set the relationships
    Publisher.persist(publisher);
    book.publisher = publisher;
    Artist.persist(artist);
    book.artist = artist;
    // persist the book
    Book.persist(book);
    // create a customer
    Customer customer = new Customer("customer name", "customer last name", "customer email");
    customerRepository.persist(customer);
    // create an order line
    OrderLine orderLine = new OrderLine();
    orderLine.item = book;
    orderLine.quantity = 2;
    // create a purchase order
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.orderLines.add(orderLine);
    purchaseOrder.customer = customer;
    PurchaseOrder.persist(purchaseOrder);
  }
}
