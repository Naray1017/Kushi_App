package com.kushi.in.kushi.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";  // Maps to src/main/resources/templates/welcome.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // Maps to src/main/resources/templates/about.html
    }

    @GetMapping("/pestcontrol")
    public String pestControl() {
        return "pestcontrol";  // Maps to src/main/resources/templates/pestcontrol.html
    }

    @GetMapping("/residential-cleaning")
    public String residentialCleaning() {
        return "residential-cleaning";  // Maps to src/main/resources/templates/residential-cleaning.html
    }

    @GetMapping("/commercial-cleaning")
    public String commercialCleaning() {
        return "commercial-cleaning";  // Maps to src/main/resources/templates/commercial-cleaning.html
    }

    @GetMapping("/vlog")
    public String vlog() {
        return "vlog";  // Maps to src/main/resources/templates/vlog.html
    }

    @GetMapping("/users")
    public String users() {
        return "users";  // Maps to src/main/resources/templates/users.html
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings";  // Maps to src/main/resources/templates/settings.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";  // Maps to src/main/resources/templates/logout.html
    }

    @GetMapping("/orders")
    public String orders() {
        return "orders";  // Maps to src/main/resources/templates/orders.html
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";  // Maps to src/main/resources/templates/admin.html
    }
    @GetMapping("/offerimg")
    public String offerimg() {
        return "offerimg";  // Maps to src/main/resources/templates/orders.html
    }
    @GetMapping("/services")
    public String servicses() {
        return "services";
    }

}