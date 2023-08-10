package com.itbcafrica.microservices.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book extends Item {
  @Column(length = 18)
  public String isbn;

  @Column(name = "nb_of_pages")
  public int nbOfPages;

  @Column(name = "publication_date")
  public LocalDate publicationDate;

  @Column(length = 20)
  @Enumerated(EnumType.STRING)
  public Language language;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "publisher_fk")
  public Publisher publisher;
}
