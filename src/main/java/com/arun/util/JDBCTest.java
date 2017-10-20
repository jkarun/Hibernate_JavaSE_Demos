package com.arun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		try {
    		//"jdbc:jtds:sqlserver://192.168.0.117:1433/shivalatest", "sa","123"
			Connection con = DriverManager.getConnection("jdbc:sqlite:E:\\arun files\\e books\\SpringHibernateDB\\hibernate_db.sqlite","sa","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from country");
			while ( rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
