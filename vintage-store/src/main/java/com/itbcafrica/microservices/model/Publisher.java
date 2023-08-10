package com.itbcafrica.microservices.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="t_publishers")
public class Publisher extends PanacheEntity{
    public String name;
    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    public Publisher(){
    }

    public Publisher(String name){
        this.name=name;
    }
    public static Optional<Publisher> findByName(String name){
        Optional<Publisher> publisher=Publisher.find("name", name).firstResultOptional();
        return publisher;
    }

    public static List<Publisher> findContainName(String name){
        List<Publisher> publishers=Publisher.list("name like ?1", "%"+name+"%");
        return publishers;
    }
}

