package com.kushi.in.kushi.service;

import com.kushi.in.kushi.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kushi.in.kushi.entity.Order;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Fetch all orders sorted by order date
    public List<Order> getAllOrdersSortedByDate() {
        return orderRepository.findAllByOrderByOrderDateDesc();
    }

    // Get order by id
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Fetch the most recent 5 orders
    public List<Order> getRecentOrders() {
        return orderRepository.findAllByOrderByOrderDateDesc().stream().limit(5).toList();
    }

    // Save a new or updated order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order by id
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}