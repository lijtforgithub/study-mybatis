package com.ljt.study.entity;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午7:49:35
 */
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 8870530388297787327L;
	
	private int id;
	private String vin;
	private String year;
	private String make;
	private String model;
	private String color;
	private int type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getType() {
		return type;
	}
	protected void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", color=" + color + "]";
	}

}
