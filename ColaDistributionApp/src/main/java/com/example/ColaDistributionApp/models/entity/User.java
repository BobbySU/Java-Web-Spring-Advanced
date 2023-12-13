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

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private Position position;
    @Column
    private Date created;

    private List<Plant> plants;
    private List<Shop> shops;
    private List<Order> orders;

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
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
    @Enumerated(EnumType.STRING)
    public Position getPosition() {
        return position;
    }

    public User setPosition(Position position) {
        this.position = position;
        return this;
    }
}
