package com.itbcafrica.microservices.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.Instant;

public class Artist {
  private Long id;
  private String name;
  private String bio;
  private Instant createdDate = Instant.now();

  public Artist() {}

  public Artist(String name, String bio) {
    this.name = name;
    this.bio = bio;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  @Entity
  public static class Publisher extends PanacheEntity{

    public String name;
    public Instant createDate = Instant.now();

      public Publisher(){
      }

      public Publisher(String name){
          this.name=name;
      }
  }
}
