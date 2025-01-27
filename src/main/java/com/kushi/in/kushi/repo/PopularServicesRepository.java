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
                   si.IMAGE_URL AS imageUrl  -- Join with TBL_SERVICE_INFO to get the image URL
            FROM tbl_booking_info b
            LEFT JOIN TBL_RATING r ON b.Booking_Service_name = r.SERVICE_NAME
            LEFT JOIN tbl_service_info si ON b.Booking_Service_name = si.SERVICE_NAME  -- Correct join with TBL_SERVICE_INFO
            GROUP BY b.Booking_Service_name, si.IMAGE_URL
            ORDER BY SUM(b.Booking_Amount) DESC
            LIMIT 5
        """, nativeQuery = true)
    List<Object[]> findTop5MostBookedServicesWithRatingAndImage();
}
