package com.example.web_login.repo;








import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web_login.entity.User;
   @Repository
public interface Userrepo extends JpaRepository<User,Long> {
	  

}