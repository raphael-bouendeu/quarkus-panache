package com.itbcafrica.microservices.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "t_artists")
public class Artist extends PanacheEntity {

  public String name;

  @Column(length = 3000)
  public String bio;

  @Column(name = "created_date", nullable = false)
  public Instant createdDate = Instant.now();

  public Artist() {}

  public Artist(String name, String bio) {
    this.name = name;
    this.bio = bio;
  }
}
