package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.entity.Order;
import com.example.ColaDistributionApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public OrderService(OrderRepository orderRepository, LoggedUser loggedUser) {
        this.orderRepository = orderRepository;
        this.loggedUser = loggedUser;
    }

    public List<Order> findAllByUserId() {
        if (loggedUser.isEmpty()) {
            return List.of();
        }
        return this.orderRepository.findAll();
    }
}
