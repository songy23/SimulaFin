package simula.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import simula.model.Stock_Stat;

public class Stock_StatDao {
	
	protected ConnectionManager connectionManager;

	private static Stock_StatDao instance = null;
	protected Stock_StatDao() {
		connectionManager = new ConnectionManager();
	}
	public static Stock_StatDao getInstance() {
		if(instance == null) {
			instance = new Stock_StatDao();
		}
		return instance;
	}

	public Stock_Stat getStock_StatbyTicker(String Ticker) throws SQLException {
		String selectStock_Stat = "SELECT Ticker, Daily_range, Yearly_range, Open, Vol_avg, MktCap, P_E, Div_yield, EPS, Shares, Beta, InstOwn "
				+ "FROM Stock_Stat WHERE Ticker=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectStock_Stat);
			selectStmt.setString(1, Ticker);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultTicker = results.getString("Ticker");
				String Daily_range = results.getString("Daily_range");
				String Yearly_range = results.getString("Yearly_range");
				float Open = results.getFloat("Open");
				String Vol_avg = results.getString("Vol_avg");
				String MktCap = results.getString("MktCap");
				float P_E = results.getFloat("P_E");
				String Div_yield = results.getString("Div_yield");
				float EPS = results.getFloat("EPS");
				String Shares = results.getString("Shares");
				float Beta = results.getFloat("Beta");
				float InstOwn = results.getFloat("InstOwn");
				Stock_Stat stock_stat = 
						new Stock_Stat(resultTicker, Daily_range, Yearly_range, Open, Vol_avg, MktCap, P_E, Div_yield, EPS, Shares, Beta, InstOwn);
				return stock_stat;
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
}
