package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.Login;
import com.java.service.LoginService;



/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
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
		// TODO Auto-generated method stub
		handleRequest(request,response);
	}
	private void handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	  
		String action = request.getParameter("action");
		String credentials=null;
		
		if("Login".equalsIgnoreCase(action)){
			String id=request.getParameter("userid");
			String pass=request.getParameter("password");
			LoginService ls=new LoginService();
			Login l=ls.getDetails(id);
			
		if(id.equals(String.valueOf(l.getuId())))
			
		{
			if(pass.equals(l.getPassword())){
			
			request.setAttribute("details" , l);
			RequestDispatcher dispatcher = request.getRequestDispatcher("enroll.jsp");
			dispatcher.forward(request,response);

			}
			else{
				credentials="wrongpass";
				request.setAttribute("cred" , credentials);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request,response);

			}
		}
		else
		{
			credentials="wronguser";
			System.out.println("userrr"+credentials);
			request.setAttribute("cred" , credentials);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request,response);		
			
		}
		}
	}

}
