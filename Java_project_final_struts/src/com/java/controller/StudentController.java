package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.CourseDetails;
import com.java.bean.Login;
import com.java.bean.StudentDetails;
import com.java.service.StudentService;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request,response);
	}
	private void handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	  StudentService ss=new StudentService();
		String action = request.getParameter("action");
		String userid=null;
		String username=null;
		
		if("Register".equalsIgnoreCase(action)){
			 userid=request.getParameter("userid");
			 username=request.getParameter("username");
			String mailid=request.getParameter("mailid");
			String phoneno=request.getParameter("phoneno");
			String password=request.getParameter("password");
			StudentDetails sd=new StudentDetails(Integer.parseInt(userid), mailid,Double.parseDouble(phoneno), username, password);
			Login l=ss.addStudent(sd);
			
			if(l.getCourse()!="notexists"){
				if("yes".equalsIgnoreCase(l.getUniq())){
					request.setAttribute("details" , l);
					RequestDispatcher dispatcher = request.getRequestDispatcher("enroll.jsp");
					dispatcher.forward(request,response);
				}
				else{
					request.setAttribute("login" , l);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
					dispatcher.forward(request,response);
				}
				
			}else{
				request.setAttribute("login" , l);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
				dispatcher.forward(request,response);
			}
		}
		
		if("Enroll".equalsIgnoreCase(action)){
	
			String subject=request.getParameter("subjects");
			userid=request.getParameter("useriden");
			username=request.getParameter("username");
			StudentDetails sd=new StudentDetails(Integer.parseInt(userid),username,subject);
			CourseDetails cd=ss.enrollSubjects(sd);
			
			Login l=ss.getStudentDetails(sd);
			request.setAttribute("details" , l);
			request.setAttribute("coursedetails", cd);
			RequestDispatcher dispatcher = request.getRequestDispatcher("enroll.jsp");
			dispatcher.forward(request,response);
		}
		
	}

}
