package com.binarycod.arigato.domain;

import javax.persistence.*;

@Entity
@Table(name = "store_product") //means this inventory will be located in store_product table
public class Inventory { // inventory class connection for store_product table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "product_id") // in product table this is primary but in store_product it is foreign key
    Product product;

    @ManyToOne
    @JoinColumn(name = "store_id") // in store table this is primary key but in store_product it is foreign key
    Store store;

    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", product=" + product.getId() +
                ", store=" + store.getId() +
                ", quantity=" + quantity +
                '}';
    }
}
