package com.example.ColaDistributionApp.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    private Date created;

    private List<Product> products;
    private User buyer;

    @Column(nullable = false)
    public Date getCreated() {
        return created;
    }

    public Order setCreated(Date created) {
        this.created = created;
        return this;
    }

    @OneToMany(mappedBy = "order")
    public List<Product> getProducts() {
        return products;
    }

    public Order setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public Order setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }

    @Override
    public String toString(){
        return String.format("Order Created: %s - Bayer: %s", created, buyer);
    }
}
