package com.kushi.in.kushi.controller;

import com.kushi.in.kushi.entity.PopularServices;
import com.kushi.in.kushi.service.PopularServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/popular-services")
public class PopularServicesController {

    @Autowired
    private PopularServicesService popularServicesService;

    @GetMapping("/top-rated")
    public List<PopularServices> getTopRatedServices() {
        return popularServicesService.getTop5PopularServicesByRating();
    }
}
