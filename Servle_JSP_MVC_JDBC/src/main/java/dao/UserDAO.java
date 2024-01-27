package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/a_z_backend";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USER_SQL = "INSERT INTO users (name,email,country) VALUES"
			+ "(?, ?, ?)";


	private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country from users WHERE id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
	private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id= ?;";
	private static final String UPDATE_USER_BY_ID = "UPDATE users SET name=?, email=?, country=? WHERE id=?;";


	protected Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public List<User> selectAllUsers(){
		List<User> users= new ArrayList<>();
		//Step1: Establishing a connection

		try(Connection connection = getConnection();
				//Step2: Create a statement using connection Object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
			//Step3: Execute the query
			ResultSet rs = preparedStatement.executeQuery();

			//step4: Process the ResultSet object
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");				
				String email = rs.getString("email");
				String country = rs.getString("country");

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setCountry(country);

				users.add(user);				

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return users;

	}
	
	public boolean updateUser(User user) throws SQLException{
		boolean rowUpdated;
		
		try(Connection con = getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(UPDATE_USER_BY_ID);){
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;		
			
		}
		
		return rowUpdated;			
		
	}
	
	public User selectUser(int id) {
		User user = null;
		
		try(Connection con = getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setCountry(country);				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void insertUser(User user) throws SQLException{
		try(Connection con = getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_USER_SQL);){
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.executeUpdate();			
		}
		
	}
	
	public boolean deleteUser(int id) throws SQLException{
		boolean rowDeleted;
		try(Connection con = getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(DELETE_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			
			rowDeleted = preparedStatement.executeUpdate() > 0;			
		}
		return rowDeleted;
		
	}
	
	
	
}
