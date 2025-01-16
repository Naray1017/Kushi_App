package com.kushi.in.kushi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Handle the root URL "/"
    @GetMapping("/")
    public String welcome() {
        return "Welcome"; // This should match the "Welcome.html" template
    }

    // Other mappings remain unchanged
    @GetMapping("/about")
    public String about() {
        return "about"; // Ensure the template is 'about.html'
    }

    @GetMapping("/pestcontrol")
    public String pestControl() {
        return "pestcontrol"; // Ensure the template is 'pestcontrol.html'
    }

    @GetMapping("/residential-cleaning")
    public String residentialCleaning() {
        return "residential-cleaning"; // Ensure the template is 'residential-cleaning.html'
    }

    @GetMapping("/commercial-cleaning")
    public String commercialCleaning() {
        return "commercial-cleaning"; // Ensure the template is 'commercial-cleaning.html'
    }

    @GetMapping("/vlog")
    public String vlog() {
        return "vlog"; // Ensure the template is 'vlog.html'
    }

    // Remove this method to avoid conflict with UserController
    // @GetMapping("/users")
    // public String users() {
    //     return "users"; // Ensure the template is 'users.html'
    // }

    @GetMapping("/orders")
    public String orders() {
        return "orders"; // Ensure the template is 'orders.html'
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings"; // Ensure the template is 'settings.html'
    }

    @GetMapping("/mail")
    public String mail() {
        return "mail"; // Ensure the template is 'mail.html'
    }

    @GetMapping("/admindashboard")
    public String adminDashboard() {
        return "admindashboard"; // Ensure the template is 'admindashboard.html'
    }

    @GetMapping("/services")
    public String services() {
        return "services"; // Ensure the template is 'services.html'
    }
}
