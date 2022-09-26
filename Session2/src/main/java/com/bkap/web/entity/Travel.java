package com.bkap.web.entity;

import java.sql.Date;
import java.sql.ResultSet;

public class Travel extends IEntity<Travel> {
	private int trId;
	private String name;
	private double price;
	private int catId;
	private Date startDate;
	public Travel() {
	}
	public Travel(int trId, String name, double price, int catId, Date startDate) {
		super();
		this.trId = trId;
		this.name = name;
		this.price = price;
		this.catId = catId;
		this.startDate = startDate;
	}
	public int getTrId() {
		return trId;
	}
	public void setTrId(int trId) {
		this.trId = trId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Override
	public Travel toEntity(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
