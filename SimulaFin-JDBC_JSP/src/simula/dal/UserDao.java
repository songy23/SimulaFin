package simula.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import simula.model.User;

public class UserDao {
	
protected ConnectionManager connectionManager;
	
	private static UserDao instance = null;
	protected UserDao() {
		connectionManager = new ConnectionManager();
	}
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	public User create(User User) throws SQLException {
		String insertUser = "INSERT INTO User(User_Name, DoB, Password, Gender, Address, Email, Profession, Education_level) "
				           + "VALUES(?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);
			
			insertStmt.setString(1, User.getUser_Name());
			insertStmt.setTimestamp(2, new Timestamp(User.getDoB().getTime()));
			insertStmt.setString(3, User.getPassword());
			insertStmt.setString(4, User.getGender());	
			insertStmt.setString(5, User.getAddress());	
			insertStmt.setString(6, User.getEmail());
			insertStmt.setString(7, User.getProfession());
			insertStmt.setString(8, User.getEducation_Level());
			insertStmt.executeUpdate();

			return User;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	
	public User delete(User User) throws SQLException {
		String deleteUser = "DELETE FROM User WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, User.getUser_Name());
			deleteStmt.executeUpdate();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	
	
	public User getUserByUser_Name(String User_Name) throws SQLException {
		String selectUser = "SELECT User_Name, DoB, Password, Gender, Address, Email, Profession, Education_Level FROM User WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, User_Name);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultUser_Name = results.getString("User_Name");
				Date dob = new Date(results.getTimestamp("DoB").getTime());
				String password = results.getString("Password");
				String gender = results.getString("Gender");
				String address = results.getString("Address");
				String email = results.getString("Email");
				String Profession = results.getString("Profession");
				String education_level = results.getString("Education_Level");
				User User = new User(resultUser_Name, dob, password, gender, address, email, Profession, education_level);
				return User;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	public User updatePassword(User user, String newPassword) 
			throws SQLException {
		String updatePassword = "UPDATE User SET Password=? WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updatePassword);
			updateStmt.setString(1, newPassword);
			updateStmt.setString(2, user.getUser_Name());
			updateStmt.executeUpdate();

			user.setPassword(newPassword);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public User updateAddress(User user, String newAddress) 
			throws SQLException {
		String updateAddress = "UPDATE User SET Address=? WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAddress);
			updateStmt.setString(1, newAddress);
			updateStmt.setString(2, user.getUser_Name());
			updateStmt.executeUpdate();

			user.setAddress(newAddress);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public User updateEmail(User user, String newEmail) 
			throws SQLException {
		String updateEmail = "UPDATE User SET Email=? WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateEmail);
			updateStmt.setString(1, newEmail);
			updateStmt.setString(2, user.getUser_Name());
			updateStmt.executeUpdate();

			user.setEmail(newEmail);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}

}
