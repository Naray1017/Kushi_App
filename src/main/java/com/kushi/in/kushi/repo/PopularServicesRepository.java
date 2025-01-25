package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.PopularServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularServicesRepository extends JpaRepository<PopularServices, Long> {

    @Query(value = """
            SELECT Booking_Service_name AS serviceName, NULL AS rating, SUM(Booking_Amount) AS amount
            FROM tbl_booking_info
            GROUP BY Booking_Service_name
            ORDER BY SUM(Booking_Amount) DESC
            LIMIT 5
        """, nativeQuery = true)
    List<Object[]> findTop5MostBookedServices();
}
