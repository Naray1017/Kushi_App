package com.kushi.in.kushi.controller;





import com.kushi.in.kushi.entity.Order;
import com.kushi.in.kushi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to fetch orders based on filter
    @GetMapping("/admin/api/orders")
    public List<Order> getOrders(@RequestParam(defaultValue = "all") String filter) {
        LocalDate today = LocalDate.now();
        LocalDate startDate;

        switch (filter) {
            case "1week":
                startDate = today.minusWeeks(1);
                break;
            case "1month":
                startDate = today.minusMonths(1);
                break;
            case "all":
            default:
                startDate = LocalDate.MIN;  // Fetch all orders
                break;
        }

        return orderService.getOrdersSince(startDate);
    }
}
