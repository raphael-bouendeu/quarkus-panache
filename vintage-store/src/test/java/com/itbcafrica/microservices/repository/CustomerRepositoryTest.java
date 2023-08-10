package com.itbcafrica.microservices.repository;

import com.itbcafrica.microservices.model.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
public class CustomerRepositoryTest{

  @Inject CustomerRepository customerRepository;

  @Test
  @Transactional
  public void shouldCreateAndFindAnCustomer() {
    Assertions.assertTrue(customerRepository.listAllDans().size()<=customerRepository.findAll().count());
    customerRepository = new CustomerRepository();
    Customer customer = new Customer("firstName", "lastName", "email");
    customerRepository.persist(customer);

    Assertions.assertNotNull(customer);
    Customer customerRepositoryById = customerRepository.findById(customer.getId());
    Assertions.assertEquals("firstName", customer.getFirstName());
  }
}
