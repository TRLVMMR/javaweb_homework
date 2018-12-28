package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.domain.UserMapper;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapperp; 
	public List<User> listAll() {
		return userMapperp.selectAll();
	}   
}
