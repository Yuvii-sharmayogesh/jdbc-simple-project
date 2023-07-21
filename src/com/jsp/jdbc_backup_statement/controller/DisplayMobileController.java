package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayMobileController {
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
		String displayMobileQuery="select * from mobile";
		
		ResultSet resultset=statement.executeQuery(displayMobileQuery);
		
		resultset.next();
		 int id = resultset.getInt("idmobile");
		 String name = resultset.getString("mobilename");
		 String color = resultset.getString("mobilecolor");
		 double price= resultset.getDouble("mobileprice");
		 
		 System.out.println("id = "+id);
		 System.out.println("name = "+name);
		 System.out.println("color = "+color);
		 System.out.println("price = "+price);
		
		
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



	


