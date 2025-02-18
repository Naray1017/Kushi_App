package com.kushi.in.kushi.controller;

import com.kushi.in.kushi.service.BookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingInfoController {

    @Autowired
    private BookingInfoService bookingInfoService;

    @GetMapping("/top3-weekly-services")
    public ResponseEntity<?> getTop3ServicesForWeeks(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "month", required = false) Integer month) {

        // Default to the current year and month if not provided
        LocalDate now = LocalDate.now();
        year = (year != null) ? year : now.getYear();
        month = (month != null) ? month : now.getMonthValue();

        // Get the start and end of the month
        LocalDate startOfMonth = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

        // Fetch the top 3 services for each week in the month
        List<Map<String, Object>> weeklyTop3Services = bookingInfoService.getTop3ServicesByWeeks(startOfMonth, endOfMonth);

        if (weeklyTop3Services.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No services found for the given period.");
        }

        return ResponseEntity.ok(weeklyTop3Services);
    }
}
