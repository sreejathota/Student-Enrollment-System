package com.java.bean;

import java.util.List;

public class Login {
	private int uId;
	private String uName;
	 private String password;
	 private String course;
	 private List<String> subjects;
	 private List<String> enrolledSubjects;
	 private String uniq;
	
	public List<String> getEnrolledSubjects() {
		return enrolledSubjects;
	}
	public void setEnrolledSubjects(List<String> enrolledSubjects) {
		this.enrolledSubjects = enrolledSubjects;
	}
	public String getUniq() {
		return uniq;
	}
	public void setUniq(String uniq) {
		this.uniq = uniq;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	public Login(int uId, String uName, String password, String course,
			List<String> subjects) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.password = password;
		this.course = course;
		this.subjects = subjects;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	} 
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Login() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [uId=" + uId + ", uName=" + uName + ", password="
				+ password + ", course=" + course + "]";
	}
	
	
	
}
