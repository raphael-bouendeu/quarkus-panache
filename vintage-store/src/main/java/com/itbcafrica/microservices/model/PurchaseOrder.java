package com.itbcafrica.microservices.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_purchase_orders")
public class PurchaseOrder extends PanacheEntity {
  @Column(name = "purchase_order_date", nullable = false)
  public LocalDate date = LocalDate.now();

  @OneToMany(mappedBy = "purchaseOrder", cascade = { CascadeType.PERSIST}, orphanRemoval = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  public List<OrderLine> orderLines = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_fk")
  public Customer customer;

  @Column(name = "created_date")
  public Instant createdDate = Instant.now();

}
