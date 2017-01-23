package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.Login;
import com.java.util.DBConnectionUtil;

public class OracleLoginDAO implements LoginDAO {

	public Login getDetails(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		int userid=Integer.parseInt(id);
		String course=null;
		List<String> subjects = new ArrayList<String>();
		List<String> enrolledsubjects = new ArrayList<String>();

		ResultSet rs=null;
		ResultSet rs1=null;
        Login log= new Login();
    	conn=DBConnectionUtil.getconnection();
     
        try {
			
			pstmt1=conn.prepareStatement("select course from master where STUDENT_ID=?");
			pstmt1.setInt(1, userid);
			rs1=pstmt1.executeQuery();
			while(rs1.next()){
				course=rs1.getString(1);
				
			}
			log.setCourse(course);
			pstmt1=conn.prepareStatement("select COURSE_NAME from COURSES where COURSE_TYPE=(select course from master where STUDENT_ID=?)");
			pstmt1.setInt(1, userid);
			rs1=pstmt1.executeQuery();
			while(rs1.next()){
				subjects.add(rs1.getString(1));
				
			}
			log.setSubjects(subjects);
			if("graduate".equalsIgnoreCase(course)){
				pstmt=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM GRADUATE where STUDENTID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					log.setuName(rs.getString(1));
					log.setuId(rs.getInt(2));
					log.setPassword(rs.getString(3));
				}
				pstmt=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM GSTUDENTDTS where STUDENT_ID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					
					enrolledsubjects.add(rs.getString(1));
					
					
				}
			}else if("undergraduate".equalsIgnoreCase(course)){
				pstmt=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM UNDERGRADUATE where STUDENTID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					log.setuName(rs.getString(1));
					log.setuId(rs.getInt(2));
					log.setPassword(rs.getString(3));
				}
				pstmt=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM UGSTUDENTDTS where STUDENT_ID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					
					enrolledsubjects.add(rs.getString(1));
					
					
				}
				
			}else if("PhD".equalsIgnoreCase(course)){
				pstmt=conn.prepareStatement("SELECT USERNAME,STUDENTID,PASSWORD FROM PHD where STUDENTID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					
					log.setuName(rs.getString(1));
					log.setuId(rs.getInt(2));
					log.setPassword(rs.getString(3));
				}
				pstmt=conn.prepareStatement("SELECT ENROLLED_SUBJECT FROM PHDSTUDENTDTS where STUDENT_ID=?");
				pstmt.setInt(1, userid);
				rs=pstmt.executeQuery();
				while(rs.next()){
					
					enrolledsubjects.add(rs.getString(1));
					
					
				}
				
			}
			log.setEnrolledSubjects(enrolledsubjects);
			if(enrolledsubjects.size()>0)
			System.out.println("in dao"+enrolledsubjects.get(0));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnectionUtil.closestatement(pstmt);
			DBConnectionUtil.closestatement(pstmt1);
			DBConnectionUtil.closeconnection(conn);
		}	
        
     return log;
	}

}
