package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static final String CONFIG_FILE = "/config.properties";

	public static Connection getConnection() throws SQLException {
		String resourcePath = ConnectionManager.class.getResource(CONFIG_FILE).getPath();


		System.out.println(resourcePath);

		try(InputStream input = ConnectionManager.class.getResourceAsStream(CONFIG_FILE)){
			if(input== null) {
				throw new RuntimeException("Unable to find " + CONFIG_FILE);
			}
			Properties properties = new Properties();
			properties.load(input);

			String jdbcUrl = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			String driver = properties.getProperty("db.driver");

			Class.forName(driver);
			return DriverManager.getConnection(jdbcUrl,username,password);

		}
		catch(Exception e) {
			throw new SQLException("Error obtaining database connection");
		}
	}

	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
