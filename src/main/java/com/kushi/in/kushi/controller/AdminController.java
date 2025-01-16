package com.kushi.in.kushi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kushi.in.kushi.entity.Order;
import com.kushi.in.kushi.entity.User;
import com.kushi.in.kushi.service.OrderService;
import com.kushi.in.kushi.service.UserService;

@Controller
@RequestMapping("/admin")  // Ensure this controller has /admin as the base path
public class AdminController {

    @Autowired
    public UserService userService;

    @Autowired
    public OrderService orderService;

    // User Management
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users"; // Template: /templates/admin/users.html
    }

    @GetMapping("/users/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add-user"; // Template: /templates/admin/add-user.html
    }

    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/admin/users"; // Handle user not found
        }
        model.addAttribute("user", user);
        return "admin/edit-user"; // Template: /templates/admin/edit-user.html
    }

    @PostMapping("/users/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    // Order Management
    @RequestMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrdersSortedByDate();
        model.addAttribute("orders", orders);
        return "admin/orders"; // Template: /templates/admin/orders.html
    }
}
