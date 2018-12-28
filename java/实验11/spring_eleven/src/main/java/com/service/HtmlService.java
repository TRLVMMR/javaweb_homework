package com.service;

import org.springframework.stereotype.Service;

@Service
public class HtmlService {
	public String getHtml() {
		return "<div style='color:red;'>abc</div>";
	}   
}
