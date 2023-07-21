package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayCustomerController {
	
	public static void main(String[] args) {
		Connection connection=null;
		try {
		//step-1 load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	    //step-2 create connection
			String url="jdbc:mysql://localhost:3306/customer";
			String user="root";
			String pass="root";
			
			
		 connection=DriverManager.getConnection(url, user, pass);
		
		//step-3 create statement
		Statement statement=connection.createStatement();
		
		//step-4 execute Query
		String displayCustomerQuery="select * from customer";
		
		ResultSet resultset=statement.executeQuery(displayCustomerQuery);
		
		
		while(resultset.next()){
		
		 int id = resultset.getInt("customerid");
		 String name = resultset.getString("customername");
		 String email = resultset.getString("customeremail");
		 int sal = resultset.getInt("customersal");
		 
		 System.out.println("id = "+id);
		 System.out.println("name = "+name);
		 System.out.println("email = "+email);
		 System.out.println("sal = "+sal);
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



	




