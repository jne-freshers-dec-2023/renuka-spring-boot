package com.completerestapi.day7.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity(name= "product_details")
@Validated
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotBlank
    private  int pid;
    @NotBlank
    private String name;
    @NotBlank
    private int price;
}
