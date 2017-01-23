package com.java.dao;

import com.java.bean.CourseDetails;
import com.java.bean.Login;
import com.java.bean.StudentDetails;

public interface StudentDAO {
	public Login addStudent(StudentDetails sd);
	public CourseDetails enrollSubjects(StudentDetails sd);
	public Login getStudentDetails(StudentDetails sd);
	public CourseDetails dropSubjects(StudentDetails sd);
}
