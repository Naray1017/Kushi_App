package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query method to find orders placed after a certain date
    List<Order> findOrdersByOrderDateAfter(LocalDate startDate);

}
