package resultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadOnlyResultSetExample {
	public static void main(String[] args) {
		 String jdbcUrl = "jdbc:mysql://localhost:3306/A_Z_Backend";
	        String username = "root";
	        String password = "root";
	        
	        try {
	        	Connection con = DriverManager.getConnection(jdbcUrl,username, password);
	        	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        	
	        	ResultSet rs = stmt.executeQuery("select * from employee");
	        	
	        	try {
	        		rs.absolute(1);
	        		rs.updateString("first_name", "newName");
	        		rs.updateRow();
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	rs.close();
	        	stmt.close();
	        	con.close();        	
	        	
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	}

}
