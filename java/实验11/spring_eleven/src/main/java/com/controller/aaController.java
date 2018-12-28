package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.aaService;

@RestController
public class aaController {	
	@Autowired
	aaService myService;	
	@RequestMapping("/aa")
	public String ShowHtml() {
		return myService.getHtml();
	}   
}
