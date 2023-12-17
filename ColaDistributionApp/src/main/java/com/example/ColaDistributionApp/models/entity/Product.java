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

    private String name;
    private String description;
    private Category category;
    private Integer quantity;
    private Pack pack;
    private BigDecimal price;
    private Date created;

    private User user;
    private Order order;
    private Plant plant;
    private Shop shop;
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
    @Column(nullable = false)
    public Pack getPack() {
        return pack;
    }

    public Product setPack(Pack pack) {
        this.pack = pack;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @Column(nullable = false)
    public Date getCreated() {
        return created;
    }

    public Product setCreated(Date created) {
        this.created = created;
        return this;
    }

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
    @Column(nullable = false)
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
