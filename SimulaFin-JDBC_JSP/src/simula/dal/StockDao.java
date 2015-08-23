package simula.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simula.model.Stock;

public class StockDao {
	
	protected ConnectionManager connectionManager;

	private static StockDao instance = null;
	protected StockDao() {
		connectionManager = new ConnectionManager();
	}
	public static StockDao getInstance() {
		if(instance == null) {
			instance = new StockDao();
		}
		return instance;
	}
	
	public Stock getStockbyTicker(String Ticker) throws SQLException {
		String selectStock = "SELECT Ticker, Industry, Description "
				+ "FROM Stock WHERE Ticker=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectStock);
			selectStmt.setString(1, Ticker);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultTicker = results.getString("Ticker");
				String Industry = results.getString("Industry");
				String Description = results.getString("Description");
				Stock stock = 
						new Stock(resultTicker, Industry, Description);
				return stock;
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

	public List<Stock> getStockByIndustry(String industry) throws SQLException {
		List<Stock> stocks = new ArrayList<Stock>();
		String selectStocks = "SELECT Ticker, Industry, Description "
				+ "FROM Stock WHERE Industry=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectStocks);
			selectStmt.setString(1, industry);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String resultTicker = results.getString("Ticker");
				String Industry = results.getString("Industry");
				String Description = results.getString("Description");
				Stock stock = 
						new Stock(resultTicker, Industry, Description);
				stocks.add(stock);
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
		return stocks;
	}
}
