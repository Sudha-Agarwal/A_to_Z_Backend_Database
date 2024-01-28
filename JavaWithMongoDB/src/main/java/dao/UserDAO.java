package dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.User;

public class UserDAO {
	private final MongoCollection<Document> userCollection;
	
	public UserDAO(MongoDatabase database) {
		this.userCollection = database.getCollection("users");
	}
	
	public User getUserByUsername(String username, String password) {
		Document userDocument = userCollection.find(
				and(eq("username",username), eq("password",password))).first();
				
				if(userDocument != null) {
					User user = new User();					
					user.setUsername(username);
					user.setPassword(password);
					return user;
				}
				else {
					return null;
				}
				
	}
	

}
