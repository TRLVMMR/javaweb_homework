package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.People;
import com.service.PeopleService;

@RequestMapping("people")
@RestController
public class PeopleController {
	@Autowired
	private PeopleService peopleService; 
	@GetMapping("/all")
	public List<People> listAll() {
		return peopleService.listAll();
	}  
}
