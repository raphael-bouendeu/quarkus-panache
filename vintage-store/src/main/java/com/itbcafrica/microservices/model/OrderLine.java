package com.itbcafrica.microservices.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity {
  @ManyToOne
  @JoinColumn(name = "item_fk")
  @OnDelete(action = OnDeleteAction.CASCADE)
  public Item item;

  @Column(nullable = false)
  public Integer quantity;

  @ManyToOne
  @JoinColumn(name = "purchase_order_fk")
  @OnDelete(action = OnDeleteAction.CASCADE)
  public PurchaseOrder purchaseOrder;

  @Column(name = "created_date")
  public Instant createdDate = Instant.now();
}
