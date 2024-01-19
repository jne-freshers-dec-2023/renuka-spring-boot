package com.microservices.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderLinesItems {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private  long id ;
    private  String skuCode;
    private double price;
    private int quantity;
}
