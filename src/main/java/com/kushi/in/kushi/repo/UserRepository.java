package com.kushi.in.kushi.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.kushi.in.kushi.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}