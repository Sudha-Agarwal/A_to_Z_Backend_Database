package util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DatabaseManager {
	public static MongoDatabase getMongoDatabase() {
		String connectionString = "mongodb://localhost:27017";
		MongoClient mongoClient = MongoClients.create(connectionString);
		return mongoClient.getDatabase("myDB");
		
		
	}

}
