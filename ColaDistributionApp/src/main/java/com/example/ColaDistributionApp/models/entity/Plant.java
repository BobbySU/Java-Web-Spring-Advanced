package com.example.ColaDistributionApp.models.entity;

import com.example.ColaDistributionApp.models.entity.enums.Category;
import com.example.ColaDistributionApp.models.entity.enums.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class Plant extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Category category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;

    private List<Product> products;
    private User user;

    @OneToMany(mappedBy = "plant")
    public List<Product> getProducts() {
        return products;
    }

    public Plant setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Plant setUser(User user) {
        this.user = user;
        return this;
    }
}
