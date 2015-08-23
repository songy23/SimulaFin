package simula.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import simula.model.Historical_Price;

public class Historical_PriceDao {
	
	protected ConnectionManager connectionManager;

	private static Historical_PriceDao instance = null;
	protected Historical_PriceDao() {
		connectionManager = new ConnectionManager();
	}
	public static Historical_PriceDao getInstance() {
		if(instance == null) {
			instance = new Historical_PriceDao();
		}
		return instance;
	}
	
	public List<Historical_Price> getHistorical_PricebyTicker(String Ticker) throws SQLException {
		List<Historical_Price> Historical_Prices = new ArrayList<Historical_Price>();
		String selectHistorical_Price = "SELECT ticker, date, open, high, low, close, volume "
				+ "FROM Historical_Price WHERE Ticker=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHistorical_Price);
			selectStmt.setString(1, Ticker);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String resultTicker = results.getString("ticker");
				Date date = results.getDate("date");
				float open = results.getFloat("open");
				float high = results.getFloat("high");
				float low = results.getFloat("low");
				float close = results.getFloat("close");
				long volume = results.getLong("volume");
				Historical_Price Historical_Price = 
						new Historical_Price(resultTicker, date, open, high, low, close, volume);
				Historical_Prices.add(Historical_Price);
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
		return Historical_Prices;
	}

}
