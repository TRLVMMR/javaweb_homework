package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.huluwaService;

@RestController
public class huluwa {
	@Autowired
	huluwaService la;
	@RequestMapping("/huluwa")
	public String GetCondition() {
		return la.getCondition();
	}
}
