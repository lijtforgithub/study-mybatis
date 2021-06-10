package com.ljt.study.entity;

import com.ljt.study.enums.EngineerGrade;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午10:06:56
 */
public class Engineer extends User {

	private static final long serialVersionUID = 7810544402259822614L;
	
	private EngineerGrade grade;

	public EngineerGrade getGrade() {
		return grade;
	}
	public void setGrade(EngineerGrade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Engineer [grade=" + grade + ", " + super.toString() + "]";
	}
	
}
