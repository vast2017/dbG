package com.vijay.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {
	
	static Connection connection = null;

	public static void main(String[] args) throws SQLException {

			System.out.println("-------- MySQL JDBC Connection Testing ------------");

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}

			System.out.println("MySQL JDBC Driver Registered!");
			

			try {
				connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/qa_auto","root", "automation1");

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			
			selectQuery("SELECT * from employee");
			insertQuery();
			
			System.out.println("^^^^^^^^^^^^^^^^^^^");
			selectQuery("SELECT * from employee");
			
	}
	
	
	public static void selectQuery(String runquery) throws SQLException{  
		

		Statement statement = connection.createStatement();


		// execute select SQL stetement
		ResultSet rs = statement.executeQuery(runquery);

		while (rs.next()) {
	//		String firstname = rs.getString("firstname");
	//		int age = rs.getInt("age");
			
			String firstname = rs.getString(1);
			String age = rs.getString(2);
			System.out.println(firstname + " &&&&& " + age);
		}
	}
	
	
	public  static void insertQuery() throws SQLException{
		
		String insertTableSQL = "INSERT INTO EMPLOYEE"
				+ "(empID, firstname, lastname, Age) " + "VALUES"
				+ "(4,'mkyong','last',21)";


			Statement statement = connection.createStatement();

			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");
	}
	

}
