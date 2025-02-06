package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.PopularServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularServicesRepository extends JpaRepository<PopularServices, Long> {

    @Query(value = """
        SELECT 
            b.Booking_Service_Name AS serviceName,
            SUM(b.Booking_Amount) AS amount,
            COUNT(DISTINCT b.Booking_Id) AS bookingCount,
            MAX(si.IMAGE_URL) AS imageUrl,
            COUNT(DISTINCT b.CUSTOMER_ID) AS ratingCount  -- Unique customers who booked and rated
        FROM tbl_booking_info b
        LEFT JOIN tbl_service_info si ON b.Booking_Service_Name = si.SERVICE_NAME
        WHERE si.RATING IS NOT NULL  -- Ensure service has a rating
        GROUP BY b.Booking_Service_Name
        ORDER BY COUNT(DISTINCT b.CUSTOMER_ID) DESC  -- Sort by highest rating count
        LIMIT 5;
        """, nativeQuery = true)
    List<Object[]> findTop5PopularServicesByRating();
}
