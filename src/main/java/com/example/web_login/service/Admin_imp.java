package com.example.web_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.web_login.entity.Serevice_add;
import com.example.web_login.repo.Admin_repo;

@Repository
public class Admin_imp implements Admin_service{

	
	@Autowired
	private Admin_repo admin_repo;
	@Override
	public void register(Serevice_add serevice_add) {
		
		admin_repo.save(serevice_add);
	}

}
