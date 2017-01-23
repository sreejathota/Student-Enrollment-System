package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.CourseDetails;
import com.java.bean.Login;
import com.java.bean.StudentDetails;
import com.java.util.DBConnectionUtil;

public class OracleStudentDAO implements StudentDAO {

	public Login addStudent(StudentDetails sd) {
		// TODO Auto-generated method stub
		Login log=new Login();
		Connection conn=null;
		
		ResultSet rs=null;
		
		PreparedStatement p=null;
		int uniquestudent=0;
		conn=DBConnectionUtil.getconnection();
		log.setuId(sd.getStudent_id());
		log.setuName(sd.getUserName());
		log.setPassword(sd.getPassword());
		 int student_id=sd.getStudent_id();
		 String mail_id=sd.getMail_id();
		 Double phoneNo=sd.getPhoneNo();
		 String userName=sd.getUserName();
		 String password=sd.getPassword();
		 List<String> subjects = new ArrayList<String>();
		 String course=null;
		 /*String sql=" CREATE TABLE uff3000 " +
		 "(COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +"SALES INTEGER, TOTAL INTEGER)";*/
		
			try {
				p=conn.prepareStatement("select course from master where STUDENT_ID=?");
				p.setInt(1, student_id);
				rs=p.executeQuery();
				while(rs.next()){
					course=rs.getString(1);
					log.setCourse(course);
				}
				if(course!=null){
					p=conn.prepareStatement("select COURSE_NAME from COURSES where COURSE_TYPE=(select course from master where STUDENT_ID=?)");
					p.setInt(1, sd.getStudent_id());
					rs=p.executeQuery();
					while(rs.next()){
						subjects.add(rs.getString(1));
						
					}
					log.setSubjects(subjects);
				if("graduate".equalsIgnoreCase(course)){
					p=conn.prepareStatement("select STUDENTID from GRADUATE where STUDENTID=?");
					p.setInt(1, student_id);
					rs=p.executeQuery();	
					while(rs.next()){
						uniquestudent++;
					}
					if(uniquestudent==0){
						log.setUniq("yes");
					p=conn.prepareStatement("insert into GRADUATE values(?,?,?,?,?)");
					p.setInt(1, student_id);
					p.setString(2, mail_id);
					p.setDouble(3, phoneNo);
					p.setString(4, userName);
					p.setString(5, password);
					p.executeUpdate();
					p.close();
					}else{
						log.setUniq("no");
					}
				}
				else if("undergraduate".equalsIgnoreCase(course)){
					p=conn.prepareStatement("select STUDENTID from UNDERGRADUATE where STUDENTID=?");
					p.setInt(1, student_id);
					rs=p.executeQuery();	
					while(rs.next()){
						uniquestudent++;
					}
					if(uniquestudent==0){
						log.setUniq("yes");
					p=conn.prepareStatement("insert into UNDERGRADUATE values(?,?,?,?,?)");
					p.setInt(1, student_id);
					p.setString(2, mail_id);
					p.setDouble(3, phoneNo);
					p.setString(4, userName);
					p.setString(5, password);
					p.executeUpdate();
					System.out.println("inserted"+log.getUniq());
					p.close();
					}else{
						log.setUniq("no");
						System.out.println("not inserted"+log.getUniq());
					}
					}
				else if("PhD".equalsIgnoreCase(course)){
					p=conn.prepareStatement("select STUDENTID from PHD where STUDENTID=?");
					p.setInt(1, student_id);
					rs=p.executeQuery();	
					while(rs.next()){
						uniquestudent++;
					}
					System.out.println("exixts count"+uniquestudent);
					if(uniquestudent==0){
						
						log.setUniq("yes");
						System.out.println("unique1"+log.getUniq());
					p=conn.prepareStatement("insert into PHD values(?,?,?,?,?)");
					p.setInt(1, student_id);
					p.setString(2, mail_id);
					p.setDouble(3, phoneNo);
					p.setString(4, userName);
					p.setString(5, password);
					p.executeUpdate();
					p.close();
					}else{
						log.setUniq("no");
						System.out.println("unique2"+log.getUniq());
					}
				}
				
				}else{
					log.setCourse("notexists");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				DBConnectionUtil.closestatement(p);
				DBConnectionUtil.closeconnection(conn);
			}	
			return log;
			

	}
	public CourseDetails dropSubjects(StudentDetails sd) {
		// TODO Auto-generated method stub
		CourseDetails cd=new CourseDetails();
		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		int rs2=0;
		ResultSet rs3=null;
		ResultSet rs5=null;
		PreparedStatement p=null;
		PreparedStatement p1=null;
		PreparedStatement p2=null;
		PreparedStatement p3=null;
		PreparedStatement p4=null;
		PreparedStatement p5=null;
		String course=null;
		String enrolled="no";
		int coursecount=0;
		conn=DBConnectionUtil.getconnection();
		try {
			p=conn.prepareStatement("select course from master where STUDENT_ID=?");
			p.setInt(1, sd.getStudent_id());
			rs=p.executeQuery();
			while(rs.next()){
				course=rs.getString(1);
				
			}
			
			if("graduate".equalsIgnoreCase(course)){
				p1=conn.prepareStatement("select ENROLLED_SUBJECT from GSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
				p1.setInt(1, sd.getStudent_id());
				p1.setString(2, sd.getEnrolledsub());
				rs1=p1.executeQuery();
				while(rs1.next()){
				
					enrolled="yes";
					
				}
				
				if("yes".equalsIgnoreCase(enrolled)){
				p2=conn.prepareStatement("DELETE FROM GSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
				p2.setInt(1, sd.getStudent_id());
				p2.setString(2, sd.getEnrolledsub());
				rs2=p2.executeUpdate();
				
				if(rs2>0){
					enrolled="dropped";
					
				}
				}}
			else if("undergraduate".equalsIgnoreCase(course)){
				p1=conn.prepareStatement("select ENROLLED_SUBJECT from UGSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
				p1.setInt(1, sd.getStudent_id());
				p1.setString(2, sd.getEnrolledsub());
				rs1=p1.executeQuery();
				while(rs1.next()){
				
					enrolled="yes";
					
				}
				if("yes".equalsIgnoreCase(enrolled)){
					p2=conn.prepareStatement("DELETE FROM UGSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
					p2.setInt(1, sd.getStudent_id());
					p2.setString(2, sd.getEnrolledsub());
					rs2=p2.executeUpdate();
					if(rs2>0){
						enrolled="dropped";
						
					}
					}}
			else if("PhD".equalsIgnoreCase(course)){
				p1=conn.prepareStatement("select ENROLLED_SUBJECT from PHDSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
				p1.setInt(1, sd.getStudent_id());
				p1.setString(2, sd.getEnrolledsub());
				rs1=p1.executeQuery();
				while(rs1.next()){
				
					enrolled="yes";
					
				}
				if("yes".equalsIgnoreCase(enrolled)){
						p2=conn.prepareStatement("DELETE FROM PHDSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
						p2.setInt(1, sd.getStudent_id());
						p2.setString(2, sd.getEnrolledsub());
						rs2=p2.executeUpdate();
						if(rs2>0){
							enrolled="dropped";
							
						}
						}}
			cd.setCheck(enrolled);
			if("dropped".equalsIgnoreCase(enrolled)){
				
				p3=conn.prepareStatement("select  course_count from COURSES where course_name=?");
				p3.setString(1, sd.getEnrolledsub());
				rs3=p3.executeQuery();
				while(rs3.next()){
					coursecount=rs3.getInt(1);
				}
				coursecount=coursecount+1;
				p4=conn.prepareStatement("update COURSES set course_count=? where course_name=?");
				p4.setInt(1,coursecount);
				p4.setString(2, sd.getEnrolledsub());
				p4.executeUpdate();
			
				}
				p5=conn.prepareStatement("select * from COURSES where course_name=?");
				p5.setString(1, sd.getEnrolledsub());
				rs5=p5.executeQuery();
				while(rs5.next()){
					cd.setCourse_type(rs5.getString(1));
					cd.setCourse_name(rs5.getString(2));
					cd.setCourse_count(rs5.getInt(3));
				}
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBConnectionUtil.closestatement(p);
			DBConnectionUtil.closeconnection(conn);
		}	
		return cd;
	}

	public CourseDetails enrollSubjects(StudentDetails sd) {
		
		// TODO Auto-generated method stub
		CourseDetails cd=new CourseDetails();
		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs5=null;
		PreparedStatement p=null;
		PreparedStatement p1=null;
		PreparedStatement p2=null;
		PreparedStatement p3=null;
		PreparedStatement p4=null;
		PreparedStatement p5=null;
		String enrolled="no";
		conn=DBConnectionUtil.getconnection();
		int coursecount=0;
		String course=null;
		try {
			p=conn.prepareStatement("select course from master where STUDENT_ID=?");
			p.setInt(1, sd.getStudent_id());
			rs=p.executeQuery();
			while(rs.next()){
				course=rs.getString(1);
				
			}
		
			if("graduate".equalsIgnoreCase(course)){
				p1=conn.prepareStatement("select ENROLLED_SUBJECT from GSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
				p1.setInt(1, sd.getStudent_id());
				p1.setString(2, sd.getEnrolledsub());
				rs1=p1.executeQuery();
				while(rs1.next()){
				
					enrolled="yes";
					
				}
				cd.setCheck(enrolled);
				if("no".equalsIgnoreCase(enrolled)){
				p2=conn.prepareStatement("insert into GSTUDENTDTS values(?,?,?)");
				p2.setInt(1, sd.getStudent_id());
				p2.setString(2, sd.getUserName());
				p2.setString(3, sd.getEnrolledsub());
				p2.executeUpdate();
				}}else if("undergraduate".equalsIgnoreCase(course)){
					p1=conn.prepareStatement("select ENROLLED_SUBJECT from UGSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
					p1.setInt(1, sd.getStudent_id());
					p1.setString(2, sd.getEnrolledsub());
					rs1=p1.executeQuery();
					while(rs1.next()){
							enrolled="yes";
						
					}
					cd.setCheck(enrolled);
					if("no".equalsIgnoreCase(enrolled)){
				p2=conn.prepareStatement("insert into UGSTUDENTDTS values(?,?,?)");
				p2.setInt(1, sd.getStudent_id());
				p2.setString(2, sd.getUserName());
				p2.setString(3, sd.getEnrolledsub());
				p2.executeUpdate();
				}}else if("PhD".equalsIgnoreCase(course)){
					p1=conn.prepareStatement("select ENROLLED_SUBJECT from PHDSTUDENTDTS where STUDENT_ID=? AND ENROLLED_SUBJECT=?");
					p1.setInt(1, sd.getStudent_id());
					p1.setString(2, sd.getEnrolledsub());
					rs1=p1.executeQuery();
					while(rs1.next()){
						enrolled="yes";
						
					}
					cd.setCheck(enrolled);
					if("no".equalsIgnoreCase(enrolled)){
					p2=conn.prepareStatement("insert into PHDSTUDENTDTS values(?,?,?)");
					p2.setInt(1, sd.getStudent_id());
					p2.setString(2, sd.getUserName());
					p2.setString(3, sd.getEnrolledsub());
					p2.executeUpdate();
					}}
			if("no".equalsIgnoreCase(enrolled)){
			p3=conn.prepareStatement("select  course_count from COURSES where course_name=?");
			p3.setString(1, sd.getEnrolledsub());
			rs3=p3.executeQuery();
			while(rs3.next()){
				coursecount=rs3.getInt(1);
			}
			coursecount=coursecount-1;
			p4=conn.prepareStatement("update COURSES set course_count=? where course_name=?");
			p4.setInt(1,coursecount);
			p4.setString(2, sd.getEnrolledsub());
			p4.executeUpdate();
			}
			p5=conn.prepareStatement("select * from COURSES where course_name=?");
			p5.setString(1, sd.getEnrolledsub());
			rs5=p5.executeQuery();
			while(rs5.next()){
				cd.setCourse_type(rs5.getString(1));
				cd.setCourse_name(rs5.getString(2));
				cd.setCourse_count(rs5.getInt(3));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBConnectionUtil.closestatement(p);
			DBConnectionUtil.closestatement(p1);
			DBConnectionUtil.closestatement(p2);
			DBConnectionUtil.closestatement(p3);
			DBConnectionUtil.closestatement(p4);
			DBConnectionUtil.closestatement(p5);
			DBConnectionUtil.closeconnection(conn);
		}	
		return cd;
	}

	public Login getStudentDetails(StudentDetails sd) {
		// TODO Auto-generated method stub
		PreparedStatement p=null;
		ResultSet rs=null;
		Login log=new Login();
		Connection conn=null;
		String course=null;
		List<String> subjects = new ArrayList<String>();
		List<String> enrolledsubjects = new ArrayList<String>();
		conn=DBConnectionUtil.getconnection();
		try {
			p=conn.prepareStatement("select course from master where STUDENT_ID=?");
			p.setInt(1, sd.getStudent_id());
			rs=p.executeQuery();
			while(rs.next()){
				course=rs.getString(1);
				log.setCourse(course);
			}
			p=conn.prepareStatement("select COURSE_NAME from COURSES where COURSE_TYPE=(select course from master where STUDENT_ID=?)");
			p.setInt(1, sd.getStudent_id());
			rs=p.executeQuery();
			while(rs.next()){
				subjects.add(rs.getString(1));
				
			}
			log.setSubjects(subjects);
			if("graduate".equalsIgnoreCase(course)){
				p=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM GRADUATE where STUDENTID=?");
				p.setInt(1, sd.getStudent_id());
				rs=p.executeQuery();
				while(rs.next()){
					log.setuName(rs.getString(1));
					log.setuId(rs.getInt(2));
					log.setPassword(rs.getString(3));
				}
				p=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM GSTUDENTDTS where STUDENT_ID=?");
				p.setInt(1, sd.getStudent_id());
				rs=p.executeQuery();
				while(rs.next()){
					
					enrolledsubjects.add(rs.getString(1));
					
					
				}
				}else if("undergraduate".equalsIgnoreCase(course)){
					p=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM UNDERGRADUATE where STUDENTID=?");
					p.setInt(1, sd.getStudent_id());
					rs=p.executeQuery();
					while(rs.next()){
						log.setuName(rs.getString(1));
						log.setuId(rs.getInt(2));
						log.setPassword(rs.getString(3));
					}
					p=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM UGSTUDENTDTS where STUDENT_ID=?");
					p.setInt(1, sd.getStudent_id());
					rs=p.executeQuery();
					while(rs.next()){
						
						enrolledsubjects.add(rs.getString(1));
						
						
					}
					
					}else if("PhD".equalsIgnoreCase(course)){
						p=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM PHD where STUDENTID=?");
						p.setInt(1, sd.getStudent_id());
						rs=p.executeQuery();
						while(rs.next()){
							log.setuName(rs.getString(1));
							log.setuId(rs.getInt(2));
							log.setPassword(rs.getString(3));
						}
						p=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM PHDSTUDENTDTS where STUDENT_ID=?");
						p.setInt(1, sd.getStudent_id());
						rs=p.executeQuery();
						while(rs.next()){
							
							enrolledsubjects.add(rs.getString(1));
							
							
						}
						
						}
			log.setEnrolledSubjects(enrolledsubjects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBConnectionUtil.closestatement(p);
			DBConnectionUtil.closeconnection(conn);
		}	
		return log;
	}

	

}
