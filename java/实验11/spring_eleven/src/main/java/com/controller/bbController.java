package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.bbService;

@RestController
public class bbController{
	@Autowired
	bbService myService;
	
	@RequestMapping("/bb/{flag}")
	public String ShowHtml(@PathVariable("flag") int flag) {
		return myService.getCondition(flag);
	}   
}
