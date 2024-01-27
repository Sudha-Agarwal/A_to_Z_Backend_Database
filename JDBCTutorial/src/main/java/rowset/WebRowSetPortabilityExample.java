package rowset;

import java.io.FileReader;
import java.io.FileWriter;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetPortabilityExample {
	public static void main(String[] args) {
		try {
			WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();

			//set properties using setter methods
			webRowSet.setUrl("jdbc:mysql://localhost:3306/A_Z_Backend");
			webRowSet.setUsername("root");
			webRowSet.setPassword("root");

			webRowSet.setCommand("select * from employee");
			webRowSet.execute();
			
			
			//On machine A
			try(FileWriter fileWriter = new FileWriter("src/main/resources/webRowSetData.xml")){
				webRowSet.writeXml(fileWriter);
				System.out.println("webrowset data written");
			}
			
			//simulate transferring the xml file to machine B
			
			WebRowSet deserializedWebRowSet = RowSetProvider.newFactory().createWebRowSet();
			try(FileReader fileReader = new FileReader("src/main/resources/webRowSetData.xml")){
				deserializedWebRowSet.readXml(fileReader);
			}
			
			while(deserializedWebRowSet.next()) {
				String name = deserializedWebRowSet.getString("first_name");
				System.out.println("Name:  " + name);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
