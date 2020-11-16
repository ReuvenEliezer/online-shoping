package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    protected Product() {
        // for JPA
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
