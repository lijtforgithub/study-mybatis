package com.ljt.study.entity;

import com.ljt.study.enums.VehicleType;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午7:54:31
 */
public class Truck extends Vehicle {

	private static final long serialVersionUID = -3772819089642472273L;
	
	public Truck() {
		super();
		this.setType(VehicleType.TRUCK.getValue());
	}

	@Override
	public String toString() {
		return "Truck [" + super.toString() + "]";
	}

}
