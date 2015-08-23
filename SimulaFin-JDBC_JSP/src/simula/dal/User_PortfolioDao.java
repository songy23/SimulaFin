package simula.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import simula.model.User_Portfolio;

public class User_PortfolioDao {
	
	protected ConnectionManager connectionManager;

	private static User_PortfolioDao instance = null;
	protected User_PortfolioDao() {
		connectionManager = new ConnectionManager();
	}
	public static User_PortfolioDao getInstance() {
		if(instance == null) {
			instance = new User_PortfolioDao();
		}
		return instance;
	}
	
	public User_Portfolio create(User_Portfolio User_Portfolio) throws SQLException {
		String insertUser = "INSERT INTO User_Portfolio(User_Name, Portfolio_Name) "
				           + "VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser,
					Statement.RETURN_GENERATED_KEYS);
			
			insertStmt.setString(1, User_Portfolio.getUserName());
			insertStmt.setString(2, User_Portfolio.getPortfolio_Name());
			insertStmt.executeUpdate();

			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int portfolioId = -1;
			if(resultKey.next()) {
				portfolioId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			User_Portfolio.setPortfolio_Id(portfolioId);
			return User_Portfolio;
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
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}
	
	public User_Portfolio delete(User_Portfolio User_Portfolio) throws SQLException {
		String deleteUser_Portfolio = "DELETE FROM User_Portfolio WHERE Portfolio_Id=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser_Portfolio);
			deleteStmt.setInt(1, User_Portfolio.getPortfolio_Id());
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
	
	public User_Portfolio updatePortfolio_Name(User_Portfolio user_Portfolio, String newPortfolio_Name) 
			throws SQLException {
		String updatePortfolio_Name = "UPDATE User_Portfolio SET Portfolio_Name=? WHERE Portfolio_Id=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updatePortfolio_Name);
			updateStmt.setString(1, newPortfolio_Name);
			updateStmt.setInt(2, user_Portfolio.getPortfolio_Id());
			updateStmt.executeUpdate();

			user_Portfolio.setPortfolio_Name(newPortfolio_Name);
			return user_Portfolio;
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
	
	public User_Portfolio getUser_PortfolioByPortfolio_Id(int Portfolio_Id) throws SQLException {
		String selectUser = "SELECT Portfolio_Id, User_Name, Portfolio_Name "
				+ "FROM User_Portfolio WHERE Portfolio_Id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setInt(1, Portfolio_Id);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultPortfolio_Id = results.getInt("Portfolio_Id");
				String username = results.getString("User_Name");
				String portfolio_Name = results.getString("Portfolio_Name");
				User_Portfolio User_Portfolio = 
						new User_Portfolio(resultPortfolio_Id, username, portfolio_Name);
				return User_Portfolio;
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
	
	public List<User_Portfolio> getUser_PortfolioByUserName(String username) throws SQLException {
		List<User_Portfolio> User_Portfolios = new ArrayList<User_Portfolio>();
		String selectUser = "SELECT Portfolio_Id, User_Name, Portfolio_Name "
				+ "FROM User_Portfolio WHERE User_Name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, username);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int Portfolio_Id = results.getInt("Portfolio_Id");
				String resultusername = results.getString("User_Name");
				String portfolio_Name = results.getString("Portfolio_Name");
				User_Portfolio User_Portfolio = 
						new User_Portfolio(Portfolio_Id, resultusername, portfolio_Name);
				User_Portfolios.add(User_Portfolio);
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
		return User_Portfolios;
	}
}
