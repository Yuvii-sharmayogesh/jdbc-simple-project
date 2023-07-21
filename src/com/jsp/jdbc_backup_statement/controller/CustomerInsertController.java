package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerInsertController {
	
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
			String insertCustomerQuery="insert into customer(customerid,customername,customeremail,customersal) values(185,'Vikas','vikas12@gmail.com',35000)";
			statement.execute(insertCustomerQuery);
			
			System.out.println("Data----inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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


