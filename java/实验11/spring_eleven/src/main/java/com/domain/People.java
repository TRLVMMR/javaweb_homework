package com.domain;

import java.util.Date;

public class People {
	private int itenantid;
	private Date updatetime;
	private String extnumber;
	private String telephone;
	private String cusid;
	private String bigbyte;
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int itenantid, Date updatetime, String extnumber, String telephone, String cusid, String bigbyte) {
		super();
		this.itenantid = itenantid;
		this.updatetime = updatetime;
		this.extnumber = extnumber;
		this.telephone = telephone;
		this.cusid = cusid;
		this.bigbyte = bigbyte;
	}
	public int getItenantid() {
		return itenantid;
	}
	public void setItenantid(int itenantid) {
		this.itenantid = itenantid;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getExtnumber() {
		return extnumber;
	}
	public void setExtnumber(String extnumber) {
		this.extnumber = extnumber;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getBigbyte() {
		return bigbyte;
	}
	public void setBigbyte(String bigbyte) {
		this.bigbyte = bigbyte;
	}
	
	
}
