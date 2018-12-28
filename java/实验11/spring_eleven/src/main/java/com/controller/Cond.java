package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.Condition;

@RestController
public class Cond {
	@Autowired
	Condition newService;
	@RequestMapping("/getcond")
	public String GetCondition() {
		return newService.getCondition();
	}

}

