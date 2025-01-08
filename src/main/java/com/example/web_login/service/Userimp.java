package com.example.web_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web_login.entity.User;
import com.example.web_login.repo.Userrepo;
  @Service
public class Userimp implements UserService {
    
	@Autowired
	private Userrepo repo;
	@Override
	public void register(User user) {
		
		repo.save(user);
		
	}

}
