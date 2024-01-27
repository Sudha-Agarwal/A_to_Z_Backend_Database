import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class JDBCErrorExample {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/A_Z_Backend";
        String username = "root";
        String password = "root";
        
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
        	try {
        		insertData(connection, 1,"ABC");
        		insertData(connection, 1,"ABC");
        	}
        	 catch (SQLException e) {
        		 System.out.println("SQLException: " + e.getMessage());
        	     System.out.println("SQLState: " + e.getSQLState());
        	     System.out.println("ErrorCode: " + e.getErrorCode());
        	    
        	            System.out.println("Cause: " + e.getCause());
			}
        } catch (SQLException e) {
        	 System.out.println("SQLException: " + e.getMessage());
    	     System.out.println("SQLState: " + e.getSQLState());
    	     System.out.println("ErrorCode: " + e.getErrorCode());
    	    
    	            System.out.println("Cause: " + e.getCause());
		}

	}
	
	private static void insertData(Connection connection, int id, String name) throws SQLException{
		String sql = "Insert into example_table values(?,?)";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            
         
        }
	}

}
