package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer>{

public List<Customer> listAllDans(){
    return  list("firstName='Dan'", Sort.by("lastName"));
}
}
