package com.kushi.in.kushi.controller;


 import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import com.kushi.in.kushi.entity.Order;
import com.kushi.in.kushi.entity.User;

import com.kushi.in.kushi.service.OrderService;
import com.kushi.in.kushi.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;




    // Admin Dashboard
    @GetMapping("/")
    public String showAdminDetails(Model model) {
        model.addAttribute("adminDetails", "Admin specific details here");
        return "admin/admin"; // Template file: src/main/resources/templates/admin/admin.html
    }

    // User Management
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users"; // Template file: src/main/resources/templates/admin/users.html
    }

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Order Management
    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrdersSortedByDate();
        model.addAttribute("orders", orders);
        return "admin/orders"; // Template file: src/main/resources/templates/admin/orders.html
    }

    @PostMapping("/orders")
    @ResponseBody
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order createdOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        Order updatedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orders/recent")
    public String getRecentOrders(Model model) {
        List<Order> recentOrders = orderService.getRecentOrders();
        model.addAttribute("recentOrders", recentOrders);
        return "admin/recent-orders"; // Template file: src/main/resources/templates/admin/recent-orders.html
    }

    @GetMapping("/orders/details/{id}")
    public String getOrderDetails(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return "redirect:/admin/orders"; // Redirect if order not found
        }
        model.addAttribute("order", order);
        return "admin/order-details"; // Template file: src/main/resources/templates/admin/order-details.html
    }
    @GetMapping("/offerimages")
    public String showOfferImagesPage() {
        return "offerimages"; // Template file: src/main/resources/templates/admin/settings.html
    }

    // Settings
    @GetMapping("/settings")
    public String showSettingsPage() {
        return "settings"; // Template file: src/main/resources/templates/admin/settings.html
    }

    @GetMapping("/mail")
        public String showMail(){
        return "mail";
        }

        @GetMapping("/AdminDashboard")
    public String showAdminDashboard(){
        return "admindashboard";
        }
}
