package com.binarycod.arigato.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    Long id;

    String name;
    Double price;
    Integer size;

    public Product(){}

    public Product(Long id, String name, Double price, Integer size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
