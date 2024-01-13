package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;

import model.EmployeeBean;
import util.ConnectionManager;

public class EmployeeDAO {
	
	public static boolean registerEmployee(EmployeeBean employee) {
		Connection connection = null;
		boolean success = true;
		
		String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employee (" +
				"id INT PRIMARY KEY AUTO_INCREMENT," + 
				"FIRST_NAME VARCHAR(30) NOT NULL," + 
				"LAST_NAME VARCHAR(30) NOT NULL," + 
				"USERNAME VARCHAR(30) NOT NULL UNIQUE," + 
				"PASSWORD VARCHAR(30) NOT NULL," + 
				"ADDRESS VARCHAR(30) NOT NULL," + 
				"CONTACT VARCHAR(30) NOT NULL" + 
				")";
		
		try(PreparedStatement createTable = ConnectionManager.getConnection().prepareStatement(CREATE_TABLE_SQL)){
			createTable.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionManager.closeConnection(connection);
		}
		
		String INSERT_EMP_SQL = "INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, USERNAME,PASSWORD,ADDRESS,CONTACT) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(INSERT_EMP_SQL);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getUserName());
			stmt.setString(4, employee.getPassword());
			stmt.setString(5, employee.getAddress());
			stmt.setString(6, employee.getContact());
			
			int result= stmt.executeUpdate();
			success = (result > 0);
			
		}
		catch(SQLException e) {
			
		}
		finally {
			ConnectionManager.closeConnection(connection);
		}
		return success;
	}
	
	public static List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		Connection connection = null;
		
		try {
			connection = ConnectionManager.getConnection();
			
			CallableStatement stmt =  connection.prepareCall("{call getAllEmployees}");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				EmployeeBean emp = new EmployeeBean();
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				
				list.add(emp);
			}
		}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				ConnectionManager.closeConnection(connection);
			}
			return list;		
		
		
	}

}
