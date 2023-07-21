package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteMobileController {

	public static void main(String[] args) {
		Connection connection=null;
		try {
		//step-1 load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	    //step-2 create connection
			String url="jdbc:mysql://localhost:3306/sys";
			String user="root";
			String pass="root";
			
			
		 connection=DriverManager.getConnection(url, user, pass);
		
		//step-3 create statement
		Statement statement=connection.createStatement();
		
		//step-4 execute Query
		String deleteMobileQuery="delete from mobile where idmobile=123";
		statement.execute(deleteMobileQuery);
		System.out.println(statement);
		
		
		int id=statement.executeUpdate(deleteMobileQuery);
		System.out.println("execute update method return = "+id);
		
		if(id==1) {
			System.out.println("Data---Deleted----");
		}else {
			System.out.println("Data---is not---Deleted--check your id--");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}

