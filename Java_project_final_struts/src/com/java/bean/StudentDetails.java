package com.java.bean;

import java.util.Date;
import java.util.List;



public class StudentDetails {

	private int student_id;
	private String mail_id;
	private double phoneNo;
	private String userName;
	private String password;
	 private String enrolledsub;
	
	public String getEnrolledsub() {
		return enrolledsub;
	}
	public void setEnrolledsub(String enrolledsub) {
		this.enrolledsub = enrolledsub;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public double getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public StudentDetails(int student_id, String mail_id,
			double d, String userName, String password) {
		super();
		this.student_id = student_id;
	
		this.mail_id = mail_id;
		this.phoneNo = d;
		this.userName = userName;
		this.password = password;
	}
	public StudentDetails(int userid, String username2, String subject) {
		// TODO Auto-generated constructor stub
		student_id=userid;
		userName=username2;
		enrolledsub=subject;
	}
	@Override
	public String toString() {
		return "StudentDetails [student_id=" + student_id + ", mail_id="
				+ mail_id + ", phoneNo=" + phoneNo + ", userName=" + userName
				+ ", password=" + password + ", enrolledsub=" + enrolledsub
				+ "]";
	}
	
	
	
	
}
