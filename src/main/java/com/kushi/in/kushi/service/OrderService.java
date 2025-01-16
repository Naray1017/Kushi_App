package com.kushi.in.kushi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.kushi.in.kushi.entity.Order;
import com.kushi.in.kushi.repo.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Retrieves all orders sorted by order date in descending order
    public List<Order> getAllOrdersSortedByDate() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderDate"));
    }

    // Retrieves a single order by its ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Saves or updates an order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Deletes an order by its ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Fetch orders based on a date range (e.g., since a given date)
    public List<Order> getOrdersSince(LocalDate startDate) {
        return orderRepository.findOrdersByOrderDateAfter(startDate);
    }

    // Retrieves recent orders for the last week, last month, or custom range
    public List<Order> getRecentOrders(String timePeriod) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate;

        switch (timePeriod.toLowerCase()) {
            case "week":
                startDate = endDate.minusWeeks(1);
                break;
            case "month":
                startDate = endDate.minusMonths(1);
                break;
            case "all":
                return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderDate"));  // Get all orders
            default:
                throw new IllegalArgumentException("Invalid time period. Use 'week', 'month', or 'all'.");
        }

        return orderRepository.findOrdersByOrderDateAfter(startDate);
    }
}
