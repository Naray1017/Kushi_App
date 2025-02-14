package com.example.web_login.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web_login.entity.User;
import com.example.web_login.repo.UserLoginRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class Userimp {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserLoginRepository userLoginRepository;

    // This method retrieves top customers based on booking count
    public List<Map<String, Object>> getTopCustomers(LocalDate startDate) {
        String query = "SELECT u.USER_ID AS userId, u.USER_FIRST_NAME AS firstName, u.PROFILE_PICTURE AS profilePicture, " +
                "       COUNT(b.BOOKING_ID) AS bookingCount " +
                "FROM TBL_BOOKING_INFO b " +
                "JOIN USER_LOGIN_INFO u ON b.CUSTOMER_ID = u.USER_ID " +
                (startDate != null ? "WHERE b.BOOKING_DATE >= :startDate " : "") +
                "GROUP BY u.USER_ID, u.USER_FIRST_NAME, u.PROFILE_PICTURE " +
                "ORDER BY bookingCount DESC";

        Query nativeQuery = entityManager.createNativeQuery(query);

        if (startDate != null) {
            nativeQuery.setParameter("startDate", java.sql.Date.valueOf(startDate));
        }

        @SuppressWarnings("unchecked")
        List<Object[]> results = nativeQuery.getResultList();

        List<Map<String, Object>> topCustomers = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> customer = new HashMap<>();
            customer.put("userId", row[0]);
            customer.put("name", row[1]);
            customer.put("imageUrl", row[2]);
            customer.put("bookingCount", row[3]);
            topCustomers.add(customer);
        }

        return topCustomers;
    }

    // This method retrieves top customers with their latest booking service and date
    public List<Map<String, Object>> getTopCustomersWithService(LocalDate startDate) {
        String query = "SELECT u.USER_ID AS userId, " +
                "       u.USER_FIRST_NAME AS firstName, " +
                "       u.PROFILE_PICTURE AS profilePicture, " +
                "       COUNT(b.BOOKING_ID) AS bookingCount, " +
                "       MAX(b.BOOKING_DATE) AS bookingDate, " +
                "       MAX(b.BOOKING_TIME) AS bookingTime, " + // Selecting BOOKING_TIME
                "       b.BOOKING_SERVICE_NAME AS bookingServiceName " +
                "FROM TBL_BOOKING_INFO b " +
                "JOIN USER_LOGIN_INFO u ON b.CUSTOMER_ID = u.USER_ID " +
                (startDate != null ? "WHERE b.BOOKING_DATE >= :startDate " : "") +
                "GROUP BY u.USER_ID, u.USER_FIRST_NAME, u.PROFILE_PICTURE, b.BOOKING_SERVICE_NAME " +
                "ORDER BY MAX(b.BOOKING_DATE) DESC"; // Ordering by the latest booking date

        Query nativeQuery = entityManager.createNativeQuery(query);

        if (startDate != null) {
            nativeQuery.setParameter("startDate", java.sql.Date.valueOf(startDate));
        }

        @SuppressWarnings("unchecked")
        List<Object[]> results = nativeQuery.getResultList();

        List<Map<String, Object>> topCustomers = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> customer = new HashMap<>();
            customer.put("userId", row[0]);
            customer.put("name", row[1]); // Mapping firstName to name
            customer.put("imageUrl", row[2]); // Mapping profilePicture to imageUrl
            customer.put("bookingCount", row[3]);
            customer.put("bookingDate", row[4]); // Adding bookingDate
            customer.put("bookingTime", row[5]); // Adding bookingTime
            customer.put("bookingServiceName", row[6]); // Adding bookingServiceName
            topCustomers.add(customer);
        }

        return topCustomers;
    }

    // Register method if needed
    public void register(User user) {
        // Logic to register the user
    }
    public double getTOTAL_AMOUNT() {
        return getTOTAL_AMOUNT();
    }

}