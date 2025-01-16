package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Fetch user by ID
    User findById(long id);

    List<User> findBySubscribedServicesContaining(String service);

    // You can add more queries if needed, like fetching users based on subscribed services
}
