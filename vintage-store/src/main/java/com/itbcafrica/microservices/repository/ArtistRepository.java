package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.Artist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist>{
    public List<Artist> listAllArtistSorted(){
        return listAll(Sort.descending("name"));
    }
}
