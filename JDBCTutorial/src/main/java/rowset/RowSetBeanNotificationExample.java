package rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetBeanNotificationExample {
	public static void main(String[] args) {
		try {
			
			// Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/A_Z_Backend", "root", "root");
			CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			
			//set properties using setter methods
			//cachedRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
			//cachedRowSet.setUsername("root");
			//cachedRowSet.setPassword("root");
			
			cachedRowSet.setCommand("select * from employee");
			
			//Add a listener for events
			cachedRowSet.addRowSetListener(new MyRowSetListener());
			
			cachedRowSet.execute(connection);
			
			while(cachedRowSet.next()) {
				int empId = cachedRowSet.getInt("id");
				String firstName = cachedRowSet.getString("first_name");
				
				//update the data for the current row
				cachedRowSet.updateString("first_name", "updateName");
				cachedRowSet.updateRow();
				
			}
			connection.setAutoCommit(false);
			
			cachedRowSet.acceptChanges();
			connection.commit();
			
			
			//cachedRowSet.close(); //optional		
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

class MyRowSetListener implements RowSetListener{

	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("row set changed");
		
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("row changed");
		
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		System.out.println("cursor moved");
		
	}
	
}
