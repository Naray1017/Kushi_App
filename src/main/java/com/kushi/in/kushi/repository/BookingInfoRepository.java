package com.kushi.in.kushi.repository;

import com.kushi.in.kushi.entity.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {

    @Query("SELECT b FROM BookingInfo b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    List<BookingInfo> findBookingsBetweenDates(LocalDate startDate, LocalDate endDate);
}
