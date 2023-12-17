package com.example.ColaDistributionApp.models.entity;

import com.example.ColaDistributionApp.models.entity.enums.Position;
import com.example.ColaDistributionApp.models.entity.enums.Role;
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
@Table(name = "users")
public class User extends BaseEntity{

    private String username;
    private String password;
    private String fullName;
    private String email;
    private Role role;
    private Position position;
    private Date created;

    private List<Plant> plants;
    private List<Shop> shops;
    private List<Order> orders;
    private List<Product> products;
    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    @Column
    public Date getCreated() {
        return created;
    }

    public User setCreated(Date created) {
        this.created = created;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @OneToMany(mappedBy = "user")
    public List<Plant> getPlants() {
        return plants;
    }

    public User setPlants(List<Plant> plants) {
        this.plants = plants;
        return this;
    }

    @OneToMany(mappedBy = "user")
    public List<Shop> getShops() {
        return shops;
    }

    public User setShops(List<Shop> shops) {
        this.shops = shops;
        return this;
    }

    @OneToMany(mappedBy = "buyer")
    public List<Order> getOrders() {
        return orders;
    }

    public User setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }
    @OneToMany(mappedBy = "user")
    public List<Product> getProducts() {
        return products;
    }

    public User setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Position getPosition() {
        return position;
    }

    public User setPosition(Position position) {
        this.position = position;
        return this;
    }
}
