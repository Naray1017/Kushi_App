package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.PopularServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularServicesRepository extends JpaRepository<PopularServices, Long> {

    @Query(value = """
        SELECT b.Booking_Service_name AS serviceName,
               AVG(r.RATING) AS rating, 
               SUM(b.Booking_Amount) AS amount,
               COUNT(b.Booking_Service_name) AS bookingCount,
               MAX(si.IMAGE_URL) AS imageUrl  -- Use MAX to pick one image for each service
        FROM tbl_booking_info b
        LEFT JOIN TBL_RATING r ON b.Booking_Service_name = r.SERVICE_NAME
        LEFT JOIN tbl_service_info si ON b.Booking_Service_name = si.SERVICE_NAME
        GROUP BY b.Booking_Service_name
        ORDER BY SUM(b.Booking_Amount) DESC
        LIMIT 5
    """, nativeQuery = true)
    List<Object[]> findTop5MostBookedServicesWithRatingAndImage();
}