package com.itbcafrica.microservices.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CD extends Item {
  @Column(name = "music_company")
  public String musicCompagny;

  public String genre;

  @OneToMany(
      mappedBy = "cd",
      cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
      orphanRemoval = true)
  public List<Track> tracks = new ArrayList<>();
}
