package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.java.bean.Login;
import com.java.dao.OracleLoginDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Login l;
	String id;
	private List<String> enrolledsub;
	private String userName;
	private String uId;
	private List<String> sub;
	private String name;
	private String pass;
	

	public List<String> getEnrolledsub() {
		return enrolledsub;
	}

	public void setEnrolledsub(List<String> enrolledsub) {
		this.enrolledsub = enrolledsub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getSub() {
		return sub;
	}

	public void setSub(List<String> sub) {
		this.sub = sub;
	}

	
	public String execute() {
		 
		HttpServletRequest req = ServletActionContext.getRequest();
		/*String id=(req.getParameter("name"));
		String pass=(req.getParameter("pass"));*/
		OracleLoginDAO ldao = new OracleLoginDAO();
		ValueStack stack = ActionContext.getContext().getValueStack();
		
		l=ldao.getDetails(name);
		
		setUserName(l.getuName());
		setuId(String.valueOf(l.getuId()));
		sub=new ArrayList<String>();
		setSub(l.getSubjects());
		setEnrolledsub(l.getEnrolledSubjects());
		if(name.equals(String.valueOf(l.getuId())))
			
		{
			if(pass.equals(l.getPassword())){
				//Map<String, String> session = (Map) ActionContext.getContext().get("session");
				//session.put("name", l.getuName());
				return SUCCESS;

			}
			else{
				//String credentials="wrongpass";
				Map<String, Object> context = new HashMap<String, Object>();
	            context.put("errorMsg", new String("Invalid password. Try again.")); 
	            stack.push(context);
				return ERROR;
			}
		}
		else
		{
			//String credentials="wronguser";
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("errorMsg", new String("Invalid user name. Try again.")); 
            stack.push(context);
			return ERROR;
		}
		
		
	} 
	
	@Override
    public void validate() {
         if (name == null || name.trim().equals(""))
          {
        	 
             addFieldError("name","Please enter a user name to login with");
          }
         else if (pass == null || pass.trim().equals(""))
          {
        	
             addFieldError("pass","Please enter a password");
          }
         /*else if(!"[0-9]+".matches(name)){
        	 addFieldError("name","User Id should be a number");
         }*/
    }
		
}
