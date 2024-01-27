package rowset;

import java.sql.SQLException;
import javax.sql.rowset.Predicate;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;

public class FilterRowSetExample {
	public static void main(String[] args) {
		try {
			//CachedRowSet cachedRowSet = creatCachedRowSet("employee");
			
			//create a filterRowSet and set the filter criteria
			FilteredRowSet filteredRowSet = RowSetProvider.newFactory().createFilteredRowSet();
			filteredRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
			filteredRowSet.setUsername("root");
			filteredRowSet.setPassword("root");
			
			filteredRowSet.setCommand("select * from employee");
			filteredRowSet.execute();
			
			filteredRowSet.setFilter(new salaryFilter(1000));
			
			// Iterate through the filtered result
            while (filteredRowSet.next()) {
                int employeeId = filteredRowSet.getInt("id");
                String employeeName = filteredRowSet.getString("first_name");
                double salary = filteredRowSet.getDouble("salary");

                System.out.println("Employee ID: " + employeeId +
                        ", Employee Name: " + employeeName +
                        ", Salary: " + salary);
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

class salaryFilter implements Predicate{
	private int minSalary;

	public salaryFilter(int i) {
		this.minSalary = i;
	}


	@Override
	public boolean evaluate(RowSet rs) {
		try {
			int salary = ((RowSet)rs).getInt("salary");
			return salary >= 1000;
			
		}
		catch (SQLException e) {
		
		}
		return false;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
