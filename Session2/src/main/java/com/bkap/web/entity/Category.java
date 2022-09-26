package com.bkap.web.entity;

import java.sql.ResultSet;

public class Category extends IEntity<Category> {
	private int id;
	private String catname;
	private int counts;
	
	
	public Category() {
	}
	
	public Category(int id, String catname, int counts) {
		super();
		this.id = id;
		this.catname = catname;
		this.counts = counts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}

	@Override
	public Category toEntity(ResultSet rs) throws Exception {
		this.id = rs.getInt("catId");
		this.catname = rs.getString("catname");
		this.counts = rs.getInt("counts");
		return this;
	}
	
}
