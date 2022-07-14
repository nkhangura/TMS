package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.WorkLog;

public class DB {
Connection con;
	
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/<< DB name >>", "root", "<< password >>");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void dbClose() {
		try {
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Option 1: Create worklog
	public void createWorklog(WorkLog worklog) {
		dbConnect();
		String sql = "insert into worklog(description, creationDate, eid)" + "values (?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, worklog.getDescription());
			pstmt.setString(2, worklog.getCreationDate());
			pstmt.setInt(3, worklog.getEmp_id());
			pstmt.executeUpdate();
		}
		catch( SQLException e) {
			e.printStackTrace();
		}		
		dbClose();
	}

	// Option 2: Update worklog
	public WorkLog getWorkLogToUpdate(int worklogID) {
		dbConnect();
		WorkLog worklog = new WorkLog();
		String sql = "select * from worklog where id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, worklogID);
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			worklog = new WorkLog(rst.getInt("id"), 
					rst.getString("description"),
					rst.getString("creationDate"),
					rst.getInt("eid"));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return worklog;
	}
	
	public void updateWorkLogInfo(WorkLog wLog) {

		dbConnect();
		String sql = "update worklog set description = ? where id = ?";//, creationDate = ?, eid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wLog.getDescription());
			pstmt.setInt(2, wLog.getId());
	//		pstmt.setString(2, wLog.getCreationDate());
	//		pstmt.setInt(3, wLog.getEmp_id());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		dbClose();
	}
	
	// Option 3: Delete worklog
	public void deleteWorklog(int worklogToDelete) {
		dbConnect();
		String sql = "delete from worklog where id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, worklogToDelete);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();		
	}
	
	// Option 4: Show Employee's own worklogs
	public List<WorkLog> getEmployeeWorkLogs(int empid) {
		dbConnect();
		List<WorkLog> worklogList = new ArrayList<>();
		String sql = "select * from worklog where eid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empid);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String description = rst.getString("description");
				String creationDate = rst.getString("creationDate");
				int employeeId = rst.getInt("eid");
				
				WorkLog wl = new WorkLog(id,description,creationDate,employeeId);
				worklogList.add(wl);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return worklogList;
	}
	
	// Option 5: Show all worklogs
	public List<WorkLog> getAllWorkLogs() {
		dbConnect();
		List<WorkLog> worklogList = new ArrayList<>();
		String sql = "select * from worklog";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String description = rst.getString("description");
				String creationDate = rst.getString("creationDate");
				int employeeId = rst.getInt("eid");
				
				WorkLog wl = new WorkLog(id,description,creationDate,employeeId);
				worklogList.add(wl);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return worklogList;
	}


	
}

