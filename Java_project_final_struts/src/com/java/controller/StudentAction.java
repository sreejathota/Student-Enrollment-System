package com.java.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.bean.CourseDetails;
import com.java.bean.Login;
import com.java.bean.StudentDetails;
import com.java.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public StudentAction() {
		
	}

	String userid=null;
	String username1=null;
	private String hiddenValue1;
	private String hiddenValue2;
	private String userName;
	private String username;
	private int uId;
	private List<String> enrolledsub;
	private CourseDetails cd1;
	private List<String> sub;
	private String password;
	private String mailid;
	private String phoneno;
	private String subjects;
	
	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public List<String> getEnrolledsub() {
		return enrolledsub;
	}

	public void setEnrolledsub(List<String> enrolledsub) {
		this.enrolledsub = enrolledsub;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHiddenValue1() {
		return hiddenValue1;
	}

	public void setHiddenValue1(String hiddenValue1) {
		this.hiddenValue1 = hiddenValue1;
	}

	public String getHiddenValue2() {
		return hiddenValue2;
	}

	public void setHiddenValue2(String hiddenValue2) {
		this.hiddenValue2 = hiddenValue2;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public List<String> getSub() {
		return sub;
	}

	public void setSub(List<String> sub) {
		this.sub = sub;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	StudentService ss=new StudentService();
	
	public String register1() throws Exception{
		//HttpServletRequest request = ServletActionContext.getRequest();
		/*userid=request.getParameter("userid");
		 username1=request.getParameter("username");
		String mailid=request.getParameter("mailid");
		String phoneno=request.getParameter("phoneno");
		String password=request.getParameter("password")*/;
	//Map<String, Object> session = (Map) ActionContext.getContext().get("session");
		StudentDetails sd=new StudentDetails(Integer.parseInt(userid), mailid,Double.parseDouble(phoneno), username, password);
		Login l=ss.addStudent(sd);
		setUserName(l.getuName());
		setuId(l.getuId());
		/*Map<String,String > context1 = new HashMap<String,String >();
		context1.put("uu", String.valueOf(l.getuId())); */
		setSub(l.getSubjects());
		setEnrolledsub(l.getEnrolledSubjects());
		ValueStack stack = ActionContext.getContext().getValueStack();
		if(l.getCourse()!="notexists"){
			
			if("yes".equalsIgnoreCase(l.getUniq())){
				
				//session.put("uId", l.getuId());
				return SUCCESS;
			}
			else{
				//session.put("name", l);
				Map<String, Object> context = new HashMap<String, Object>();
	            context.put("errorMsg", new String("Student already registered")); 
	            stack.push(context);
				return ERROR;
			}
			
		}else{
			//session.put("name", l);
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("errorMsg", new String("USER ID does not exist")); 
            stack.push(context);
			return ERROR;
		}
		
	}
	public String enroll(){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String subject=request.getParameter("subjects");
		StudentDetails sd=new StudentDetails(Integer.parseInt(hiddenValue1),hiddenValue2,subjects);
		if(subjects.equals("-1")){
			Login l=ss.getStudentDetails(sd);
			setUserName(l.getuName());
			setuId(l.getuId());
			setSub(l.getSubjects());
			setEnrolledsub(l.getEnrolledSubjects());
			ValueStack stack = ActionContext.getContext().getValueStack();
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("Msg1", new String("Please select the course to enroll")); 
            stack.push(context);
			return "notselected";
		}else{
		
		 cd1=(ss.enrollSubjects(sd));
		 
		 Login l=ss.getStudentDetails(sd);
		setUserName(l.getuName());
		setuId(l.getuId());
		setSub(l.getSubjects());
		setEnrolledsub(l.getEnrolledSubjects());
		ValueStack stack = ActionContext.getContext().getValueStack();
		if("yes".equalsIgnoreCase(cd1.getCheck())){
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("Msg1", new String("You have already enrolled to "+cd1.getCourse_name())); 
            stack.push(context);
		}else{
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("Msg1", new String("You have successfully enrolled to"+cd1.getCourse_name())); 
            context.put("Msg2", new String("Only "+cd1.getCourse_count()+" "+cd1.getCourse_name()+" seats available")); 
            stack.push(context);
		}
		}
		//session.put("name", l);
		return "enroll";
	}
	public String drop(){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String subject=request.getParameter("subjects");
		
		StudentDetails sd=new StudentDetails(Integer.parseInt(hiddenValue1),hiddenValue2,subjects);
		if(subjects.equals("-1")){
			Login l=ss.getStudentDetails(sd);
			setUserName(l.getuName());
			setuId(l.getuId());
			setSub(l.getSubjects());
			setEnrolledsub(l.getEnrolledSubjects());
			ValueStack stack = ActionContext.getContext().getValueStack();
			Map<String, Object> context = new HashMap<String, Object>();
            context.put("Msg1", new String("Pleas select the course to drop")); 
            stack.push(context);
			return "notselected";
		}else{
		 cd1=(ss.dropSubjects(sd));
		 Login l=ss.getStudentDetails(sd);
		 
		 setUserName(l.getuName());
		 setuId(l.getuId());
		 setSub(l.getSubjects());
		 setEnrolledsub(l.getEnrolledSubjects());
		 ValueStack stack = ActionContext.getContext().getValueStack();
		if("no".equalsIgnoreCase(cd1.getCheck())){
				Map<String, Object> context = new HashMap<String, Object>();
	            context.put("Msg1", new String("You have not enrolled to"+cd1.getCourse_name()+" to drop the course")); 
	            stack.push(context);
			}else if("dropped".equalsIgnoreCase(cd1.getCheck())){
				Map<String, Object> context = new HashMap<String, Object>();
	            context.put("Msg1", new String("you have dropped the "+cd1.getCourse_name()+" course")); 
	            context.put("Msg2", new String("Still "+cd1.getCourse_count()+" "+cd1.getCourse_name()+" seats available")); 
	            stack.push(context);
			}
		}
		return "drop";
	}
	public String register(){
		return SUCCESS;
	}
	public String logout(){
		return SUCCESS;
	}
	/*@Override
    public void validate() {
        
		if (userid == null || userid.trim().equals("")||userid.length()<9)
          {
        	 
             addFieldError("userid","Please enter 9 digit user Id to register");
          }
         else if(!("[0-9]+".matches(userid))){
         	 addFieldError("userid","User Id should be a number");
          }
         else if (username == null || username.trim().equals(""))
          {
        	
             addFieldError("username","Please enter User name");
          }
         else if(password==null||password.trim().equals("")){
        	 addFieldError("password","Please enter Password");
         }
         else if(mailid==null||mailid.trim().equals("")){
        	 addFieldError("mailid","Please enter mail Id");
         }
         else if(phoneno==null||phoneno.trim().equals("")){
        	 addFieldError("phoneno","Please enter phone number");
         }
         else if((!"[0-9]+".matches(phoneno))||phoneno.length()<10){
         	 addFieldError("phoneno","Phone number should be a 10 digit number");
          }
    }*/
}
