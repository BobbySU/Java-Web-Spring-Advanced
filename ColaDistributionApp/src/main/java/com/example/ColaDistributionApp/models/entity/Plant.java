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

    private String name;
    private String description;
    private Category category;
    private City city;

    private List<Product> products;
    private User user;
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Plant setName(String name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Plant setDescription(String description) {
        this.description = description;
        return this;
    }

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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public Plant setCategory(Category category) {
        this.category = category;
        return this;
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public City getCity() {
        return city;
    }

    public Plant setCity(City city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString(){
        return String.format("Name: %s - %s    (%s)", name, category, city);
    }
}
