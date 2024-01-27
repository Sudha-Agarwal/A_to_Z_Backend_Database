package transaction;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCTransactionExample {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/A_Z_Backend";
        String username = "root";
        String password = "root";
        Savepoint savepoint = null;
        
        try(Connection con = DriverManager.getConnection(jdbcUrl,username,password)){
        	con.setAutoCommit(false);
        	
        	try {
        		Statement statement = con.createStatement();
        		
        		statement.executeUpdate("INSERT INTO example_table(id,name) VALUES(11,'Value1')");
        		savepoint = con.setSavepoint();
        		
        		statement.executeUpdate("INSERT INTO example_table(id,name) VALUES(10,'Value1')");
        		
        		con.commit();
        		System.out.println("Transaction commited");
        	}catch (SQLException e) {
				//rollback the changes if any error occur
        		try {
        			System.out.println(e.getMessage());
					con.rollback(savepoint);
					System.out.println("transaction rolled back");
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	finally {
				con.releaseSavepoint(savepoint);
			}
        	
        }
        catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
