package com.ljt.study.entity;

import com.ljt.study.enums.VehicleType;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午7:54:31
 */
public class Car extends Vehicle {

	private static final long serialVersionUID = -3772819089642472273L;
	
	private int doorCount;
	
	public Car() {
		super();
		this.setType(VehicleType.CAR.getValue());
	}

	public int getDoorCount() {
		return doorCount;
	}
	public void setDoorCount(int doorCount) {
		this.doorCount = doorCount;
	}

	@Override
	public String toString() {
		return "Car [doorCount=" + doorCount + ", " + super.toString() + "]";
	}

}
