package com.kushi.in.kushi.service;

import com.kushi.in.kushi.entity.BookingInfo;
import com.kushi.in.kushi.repository.BookingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingInfoService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    public List<Map<String, Object>> getTop3ServicesByWeeks(LocalDate startOfMonth, LocalDate endOfMonth) {
        List<Map<String, Object>> result = new ArrayList<>();

        // Start from the first Monday before or on the month's start date
        LocalDate weekStart = startOfMonth.with(DayOfWeek.MONDAY);
        if (weekStart.isAfter(startOfMonth)) {
            weekStart = weekStart.minusWeeks(1); // Adjust to the previous Monday if necessary
        }

        // Continue looping until the month's end
        while (!weekStart.isAfter(endOfMonth)) {
            LocalDate weekEnd = weekStart.plusDays(6); // End of the current week
            if (weekEnd.isAfter(endOfMonth)) {
                weekEnd = endOfMonth; // Adjust to the last day of the month
            }

            // Fetch bookings for the week
            List<BookingInfo> bookings = bookingInfoRepository.findBookingsBetweenDates(weekStart, weekEnd);

            // Calculate the top 3 services for the week
            Map<String, Long> serviceCounts = bookings.stream()
                    .collect(Collectors.groupingBy(BookingInfo::getBookingServiceName, Collectors.counting()));

            List<Map.Entry<String, Long>> top3Services = serviceCounts.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(3)
                    .collect(Collectors.toList());

            // Add weekly data to the result
            Map<String, Object> weeklyData = new HashMap<>();
            weeklyData.put("weekStart", weekStart);
            weeklyData.put("weekEnd", weekEnd);
            weeklyData.put("top3Services", top3Services);

            result.add(weeklyData);

            // Move to the next week
            weekStart = weekStart.plusWeeks(1);
        }

        return result;
    }

	public List<Map<String, Object>> getTop3ServicesByWeeks1(LocalDate startOfMonth, LocalDate endOfMonth) {
		// TODO Auto-generated method stub
		return null;
	}
}
