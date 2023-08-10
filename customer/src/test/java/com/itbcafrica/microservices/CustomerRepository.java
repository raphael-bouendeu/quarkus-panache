package com.itbcafrica.microservices;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CustomerRepository {

  @Inject EntityManager entityManager;

  public void persist(Customer customer) {
    entityManager.persist(customer);
  }

  public Customer findById(Long id) {
    return entityManager.find(Customer.class, id);
  }
}
