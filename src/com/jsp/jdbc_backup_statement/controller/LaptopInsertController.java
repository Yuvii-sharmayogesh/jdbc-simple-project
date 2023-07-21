package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopInsertController {
	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			//step-1 load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/laptop";
			String user="root";
			String pass="root";
			
			
			 connection=DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement
			Statement statement=connection.createStatement();
			
			
			//step-4 execute Query
			String insertLaptopQuery="insert into laptop(laptopid,laptopname,laptopcolor,laptopprice) values(380,'ACER','WHITE','45000')";
			statement.execute(insertLaptopQuery);
			
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
