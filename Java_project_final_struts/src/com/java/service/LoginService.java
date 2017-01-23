package com.java.service;

import com.java.bean.Login;
import com.java.dao.OracleLoginDAO;

public class LoginService {

	OracleLoginDAO old= new  OracleLoginDAO();
	public Login getDetails(String id) {
		return old.getDetails(id);
	}

}
