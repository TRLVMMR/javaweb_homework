package com.domain;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date birthday;
	private String address;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, Date birthday, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}