package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.People;
import com.domain.PeopleMapper;
import com.domain.User;
import com.domain.UserMapper;

@Service
public class PeopleService {
	@Autowired
	private PeopleMapper peopleMapperp; 
	public List<People> listAll() {
		return peopleMapperp.selectAll();
	}   
}
