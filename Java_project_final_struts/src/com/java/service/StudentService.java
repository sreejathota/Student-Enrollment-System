package com.java.service;

import com.java.bean.CourseDetails;
import com.java.bean.Login;
import com.java.bean.StudentDetails;
import com.java.dao.OracleStudentDAO;


public class StudentService {

	public Login addStudent(StudentDetails sd) {
		// TODO Auto-generated method stub
		OracleStudentDAO stdao= new OracleStudentDAO();
		return stdao.addStudent(sd);
	}

	public CourseDetails enrollSubjects(StudentDetails sd) {
		// TODO Auto-generated method stub
		OracleStudentDAO stdao= new OracleStudentDAO();
		return stdao.enrollSubjects(sd);
	}

	public Login getStudentDetails(StudentDetails sd) {
		// TODO Auto-generated method stub
		OracleStudentDAO stdao= new OracleStudentDAO();
		return stdao.getStudentDetails(sd);
		
	}

	public CourseDetails dropSubjects(StudentDetails sd) {
		// TODO Auto-generated method stub
		OracleStudentDAO stdao= new OracleStudentDAO();
		return stdao.dropSubjects(sd);
	}

}
