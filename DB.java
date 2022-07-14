package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.users.employeeProfile;
import com.users.poProfile;

public class DB {
	Connection con; 
	
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jira"
					,"root","Password123");
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




	public employeeProfile fetchEmployee(int id) {
		dbConnect();
		String sql="select * from Employee where idEmployee = "+id;
		employeeProfile e = new employeeProfile(); 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet  rst = pstmt.executeQuery();
			rst.next();
			e = new employeeProfile(rst.getInt("idEmployee"),
					  rst.getString("Employee_name"),
					  rst.getString("Employee_emaill"), 
					  rst.getInt("current_project"),
					  rst.getInt("points_earned")
					  );
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return e;
	}
	
	
	public poProfile fetchPO(int id) {
		dbConnect();
		String sql="select * from PO where idPO = "+id;
		poProfile e = new poProfile(); 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet  rst = pstmt.executeQuery();
			rst.next();
			e = new poProfile(rst.getInt("idPO"),
					  rst.getString("PO_name"),
					  rst.getString("PO_email"), 
					  rst.getString("PO_projects")
					  );
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return e;
	}

}
