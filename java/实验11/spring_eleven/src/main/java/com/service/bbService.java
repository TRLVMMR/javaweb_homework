package com.service;

import org.springframework.stereotype.Service;

@Service
public class bbService {
	public String getCondition(int flag) {
	String retStr="";
	if(flag==0){
	  retStr="当前为默认选项！";
	}else{
	  retStr="当前的选项为："+flag+"！";
	
	}
		return retStr;
	} 

}
