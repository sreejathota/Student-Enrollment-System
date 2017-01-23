package com.java.bean;

public class CourseDetails {
private String Course_type;
private String Course_name;
private int Course_count;
private String check;
public String getCheck() {
	return check;
}
public void setCheck(String check) {
	this.check = check;
}
public String getCourse_type() {
	return Course_type;
}
public void setCourse_type(String course_type) {
	Course_type = course_type;
}
public String getCourse_name() {
	return Course_name;
}
public void setCourse_name(String course_name) {
	Course_name = course_name;
}
public int getCourse_count() {
	return Course_count;
}
public void setCourse_count(int course_count) {
	Course_count = course_count;
}
@Override
public String toString() {
	return "CourseDetails [Course_type=" + Course_type + ", Course_name="
			+ Course_name + ", Course_count=" + Course_count + "]";
}

}
