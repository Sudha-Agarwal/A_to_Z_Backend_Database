package rowset;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetExample {
	public static void main(String[] args) {
		try {
			CachedRowSet employeeRowSet = creatCachedRowSet("employee");
			CachedRowSet departmentRowSet = creatCachedRowSet("department");
			
			JoinRowSet joinRowSet = RowSetProvider.newFactory().createJoinRowSet();
			joinRowSet.addRowSet(employeeRowSet,"department_id");
			joinRowSet.addRowSet(departmentRowSet,"department_id");
			
			//Iterate through the joined result
			while(joinRowSet.next()) {
				int employeeId = joinRowSet.getInt("id");
				String name = joinRowSet.getString("first_name");
				String dept = joinRowSet.getString("department_name");
				
				System.out.println("Id: " + employeeId + 
						", Name: " + name + 
						", Deaprtment: " + dept						
						);				
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static CachedRowSet creatCachedRowSet(String tableName) throws SQLException{
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		//set properties using setter methods
		cachedRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
		cachedRowSet.setUsername("root");
		cachedRowSet.setPassword("root");
		
		cachedRowSet.setCommand("select * from " + tableName);
		cachedRowSet.execute();
		return cachedRowSet;		
	}

}
