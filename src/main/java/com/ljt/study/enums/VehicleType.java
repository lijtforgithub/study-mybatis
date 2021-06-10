package com.ljt.study.enums;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午7:59:54
 */
public enum VehicleType {
	CAR(1, "小汽车"),
	TRUCK(2, "大货车"),
	SUV(3, "越野车");
	
	private int value;
	private String name;
	
	private VehicleType(){}
	private VehicleType(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static VehicleType getType(int value) {
		for (VehicleType type : VehicleType.values()) {
			if (value == type.getValue()) {
				return type;
			}
		}
		
		return null;
	}
	
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		switch (this) {
			case CAR:
				return CAR.getName();
			case TRUCK:
				return TRUCK.getName();
			case SUV:
				return SUV.getName();
		}
		
		return null;
	}
	
}
