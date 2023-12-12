package com.example.ColaDistributionApp.models.entity;

import com.example.ColaDistributionApp.models.entity.enums.City;
import com.example.ColaDistributionApp.models.entity.enums.Classification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Classification classification;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;

    private List<Product> products;
    private User user;

    @OneToMany(mappedBy = "shop")
    public List<Product> getProducts() {
        return products;
    }

    public Shop setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Shop setUser(User user) {
        this.user = user;
        return this;
    }
}
