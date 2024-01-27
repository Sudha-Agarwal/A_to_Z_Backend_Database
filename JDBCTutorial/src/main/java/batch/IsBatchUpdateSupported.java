package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

import java.sql.DatabaseMetaData;

public class IsBatchUpdateSupported {
	public static void main(String[] args) {
		 String jdbcUrl = "jdbc:mysql://localhost:3306/A_Z_Backend";
	        String username = "root";
	        String password = "root";
	        
	        try (Connection con = DriverManager.getConnection(jdbcUrl,username,password)){
	        	DatabaseMetaData metaData = con.getMetaData();
	        	boolean supportBatchUpdates = metaData.supportsBatchUpdates();
	        	
	        	System.out.println("Batch updates supported " + supportBatchUpdates);
	        	
	        	if(supportBatchUpdates) {
	        		Statement stmt = con.createStatement();
	        		stmt.addBatch("INSERT INTO employee (first_name, last_name, username,password) values('Sudha','Agarwal','sudha','1234');");
	        		stmt.addBatch("INSERT INTO employee (first_name, last_name, username,password) values('Sudha1','Agarwal1','sudha1','1234');");
	        		stmt.addBatch("INSERT INTO employee (first_name, last_name, username,password) values('Sudha2','Agarwal2','sudha2','1234');");
	        		
	        		int[] updateCount= stmt.executeBatch();
	        		
	        		for(int count:updateCount) {
	        			System.out.println("Update count: " + count);
	        		}
	        	}
	        	
	        	
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
