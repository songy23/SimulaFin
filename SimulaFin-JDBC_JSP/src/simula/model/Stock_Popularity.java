package simula.model;

import java.util.Date;

public class Stock_Popularity {

	protected int Stock_view_id;
	protected String Ticker;
	protected Date Timestamp;
	protected boolean Added_to_portfolio;
	
	public Stock_Popularity(String ticker, Date timestamp, boolean added_to_portfolio){
		
		this.Ticker = ticker;
		this.Timestamp = timestamp;
		this.Added_to_portfolio = added_to_portfolio;
		
		
	}

	public int getStock_view_id() {
		return Stock_view_id;
	}

	public void setStock_view_id(int stock_view_id) {
		Stock_view_id = stock_view_id;
	}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public boolean isAdded_to_portfolio() {
		return Added_to_portfolio;
	}

	public void setAdded_to_portfolio(boolean added_to_portfolio) {
		Added_to_portfolio = added_to_portfolio;
	}
}
