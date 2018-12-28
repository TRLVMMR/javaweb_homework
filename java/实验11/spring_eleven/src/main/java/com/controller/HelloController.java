package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.HtmlService;

@RestController
public class HelloController {	
	@Autowired
	HtmlService myService;	
	@RequestMapping("/showhtml")
	public String ShowHtml() {
		return myService.getHtml();
	}   
}
