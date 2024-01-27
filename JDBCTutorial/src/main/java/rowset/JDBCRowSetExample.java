package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBCRowSetExample {
	public static void main(String[] args) {
		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

			//set properties using setter methods
			jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
			jdbcRowSet.setUsername("root");
			jdbcRowSet.setPassword("root");

			jdbcRowSet.setCommand("select * from example_table");
			jdbcRowSet.execute();
			
			while(jdbcRowSet.next()) {
				int id = jdbcRowSet.getInt("id");
				String name = jdbcRowSet.getString("name");
				
				System.out.println("Id: " + id + " Name: " + name);
			}
			
			jdbcRowSet.absolute(2);
			jdbcRowSet.updateString("name", "UpdatedName");
			jdbcRowSet.updateRow();
			
			//Insert a new row
			jdbcRowSet.moveToInsertRow();
			jdbcRowSet.updateString("name", "New Name");
			jdbcRowSet.insertRow();
			jdbcRowSet.moveToCurrentRow();
			
			//Delete a row
			jdbcRowSet.absolute(4);
			jdbcRowSet.deleteRow();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
