package simula.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import simula.model.Portfolio_Stock;

public class Portfolio_StockDao {

	protected ConnectionManager connectionManager;

	private static Portfolio_StockDao instance = null;
	protected Portfolio_StockDao() {
		connectionManager = new ConnectionManager();
	}
	public static Portfolio_StockDao getInstance() {
		if(instance == null) {
			instance = new Portfolio_StockDao();
		}
		return instance;
	}
	
	public Portfolio_Stock create(Portfolio_Stock Portfolio_Stock) throws SQLException {
		String insertUser = "INSERT INTO Portfolio_Stock(Portfolio_Id, Ticker, ShareAmount) "
				           + "VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser,
					Statement.RETURN_GENERATED_KEYS);
			
			insertStmt.setInt(1, Portfolio_Stock.getPortfolio_Id());
			insertStmt.setString(2, Portfolio_Stock.getTicker());
			insertStmt.setInt(3, Portfolio_Stock.getShareAmount());
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int portfolio_stockId = -1;
			if(resultKey.next()) {
				portfolio_stockId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			Portfolio_Stock.setPortfolio_Stock_Id(portfolio_stockId);

			return Portfolio_Stock;
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
	
	public Portfolio_Stock delete(Portfolio_Stock Portfolio_Stock) throws SQLException {
		String deletePortfolio_Stock = "DELETE FROM Portfolio_Stock WHERE Portfolio_Stock_Id=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deletePortfolio_Stock);
			deleteStmt.setInt(1, Portfolio_Stock.getPortfolio_Stock_Id());
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
	
	public Portfolio_Stock updateTicker(Portfolio_Stock portfolio_Stock, String newTicker) 
			throws SQLException {
		String updateTicker = "UPDATE Portfolio_Stock SET Ticker=? WHERE Portfolio_Stock_Id=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateTicker);
			updateStmt.setString(1, newTicker);
			updateStmt.setInt(2, portfolio_Stock.getPortfolio_Stock_Id());
			updateStmt.executeUpdate();

			portfolio_Stock.setTicker(newTicker);
			return portfolio_Stock;
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
	
	
	public Portfolio_Stock updateShareamount(Portfolio_Stock portfolio_Stock, int newShareAmount) 
			throws SQLException {
		String updateShareamount = "UPDATE Portfolio_Stock SET ShareAmount=? WHERE Portfolio_Stock_Id=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateShareamount);
			updateStmt.setInt(1, newShareAmount);
			updateStmt.setInt(2, portfolio_Stock.getPortfolio_Stock_Id());
			updateStmt.executeUpdate();

			portfolio_Stock.setShareAmount(newShareAmount);
			return portfolio_Stock;
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
	
	
	public Portfolio_Stock getPortfolio_StockByPortfolio_Stock_Id(int Portfolio_Stock_Id) throws SQLException {
		String selectPortfolio_Stock = "SELECT Portfolio_Stock_Id, Portfolio_Id, Ticker, ShareAmount "
				+ "FROM Portfolio_Stock WHERE Portfolio_Stock_Id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPortfolio_Stock);
			selectStmt.setInt(1, Portfolio_Stock_Id);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultPortfolio_Stock_Id = results.getInt("Portfolio_Stock_Id");
				int Portfolio_Id = results.getInt("Portfolio_Id");
				String ticker = results.getString("Ticker");
				int shareamount = results.getInt("ShareAmount");
				Portfolio_Stock Portfolio_Stock = 
						new Portfolio_Stock(resultPortfolio_Stock_Id, Portfolio_Id, ticker, shareamount);
				return Portfolio_Stock;
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
	
	public List<Portfolio_Stock> getPortfolio_StockByPortfolio_Id(int Portfolio_Id) throws SQLException {
		List<Portfolio_Stock> Portfolio_Stocks = new ArrayList<Portfolio_Stock>();
		String selectPortfolio_Stock = "SELECT Portfolio_Stock_Id, Portfolio_Id, Ticker, ShareAmount "
				+ "FROM Portfolio_Stock WHERE Portfolio_Id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPortfolio_Stock);
			selectStmt.setInt(1, Portfolio_Id);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int Portfolio_Stock_Id = results.getInt("Portfolio_Stock_Id");
				int resultPortfolio_Id = results.getInt("Portfolio_Id");
				String ticker = results.getString("Ticker");
				int shareamount = results.getInt("ShareAmount");
				Portfolio_Stock Portfolio_Stock = 
						new Portfolio_Stock(Portfolio_Stock_Id, resultPortfolio_Id, ticker, shareamount);
				Portfolio_Stocks.add(Portfolio_Stock);
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
		return Portfolio_Stocks;
	}
	
	public List<Portfolio_Stock> getPortfolio_StockByTicker(String ticker) throws SQLException {
		List<Portfolio_Stock> Portfolio_Stocks = new ArrayList<Portfolio_Stock>();
		String selectPortfolio_Stock = "SELECT Portfolio_Stock_Id, Portfolio_Id, Ticker, ShareAmount "
				+ "FROM Portfolio_Stock WHERE Ticker=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPortfolio_Stock);
			selectStmt.setString(1, ticker);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int Portfolio_Stock_Id = results.getInt("Portfolio_Stock_Id");
				int Portfolio_Id = results.getInt("Portfolio_Id");
				String resultticker = results.getString("Ticker");
				int shareamount = results.getInt("ShareAmount");
				Portfolio_Stock Portfolio_Stock = 
						new Portfolio_Stock(Portfolio_Stock_Id, Portfolio_Id, resultticker, shareamount);
				Portfolio_Stocks.add(Portfolio_Stock);
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
		return Portfolio_Stocks;
	}
	
	
}
