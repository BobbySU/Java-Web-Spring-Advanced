package com.example.ColaDistributionApp.models.entity;

import com.example.ColaDistributionApp.models.entity.enums.Category;
import com.example.ColaDistributionApp.models.entity.enums.Pack;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Category category;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Pack pack;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Date created;

    private User user;
    private Order order;
    private Plant plant;
    private Shop shop;

    @ManyToOne
    public Order getOrder() {
        return order;
    }

    public Product setOrder(Order order) {
        this.order = order;
        return this;
    }

    @ManyToOne
    public Plant getPlant() {
        return plant;
    }

    public Product setPlant(Plant plant) {
        this.plant = plant;
        return this;
    }

    @ManyToOne
    public Shop getShop() {
        return shop;
    }

    public Product setShop(Shop shop) {
        this.shop = shop;
        return this;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public Product setUser(User user) {
        this.user = user;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString(){
        return String.format("%s - %s = %d(%s) /%.2f Lv/", name, category, quantity, pack, price);
    }
}
