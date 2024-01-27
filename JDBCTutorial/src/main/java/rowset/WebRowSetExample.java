package rowset;

import java.io.FileWriter;
import java.sql.SQLException;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetExample {
	public static void main(String[] args) {
		try {
			WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();
			
			//set properties using setter methods
			webRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
			webRowSet.setUsername("root");
			webRowSet.setPassword("root");
			
			webRowSet.setCommand("select * from employee");
			webRowSet.execute();
			
			try(FileWriter fileWriter = new FileWriter("src/main/resources/webRowSetData.xml")){
				webRowSet.writeXml(fileWriter);
				System.out.println("webrowset data written");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
