package com.kushi.in.kushi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kushi.in.kushi.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Fetch all orders sorted by order date in descending order
    List<Order> findAllByOrderByOrderDateDesc();

    // Fetch orders by status
    List<Order> findByStatus(String status);

    // Fetch orders with a customer name containing a keyword
    List<Order> findByCustomerNameContaining(String customerName);

    // Fetch orders for a specific product name
    List<Order> findByProductName(String productName);

    // Fetch orders within a total amount range
    List<Order> findByTotalAmountBetween(Double minAmount, Double maxAmount);

    // Fetch orders sorted by date with pagination
    Page<Order> findAllByOrderByOrderDateDesc(Pageable pageable);

    // Custom query for orders by status and minimum amount
    @Query("SELECT o FROM Order o WHERE o.status = :status AND o.totalAmount >= :minAmount")
    List<Order> findOrdersByStatusAndMinimumAmount(@Param("status") String status, @Param("minAmount") Double minAmount);

    // Fetch the 10 most recent orders
    List<Order> findTop10ByOrderByOrderDateDesc();
}