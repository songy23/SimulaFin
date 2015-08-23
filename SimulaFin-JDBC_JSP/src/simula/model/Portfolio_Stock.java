package simula.model;

public class Portfolio_Stock {
	
	protected int Portfolio_Stock_Id;
	protected int Portfolio_Id;
	protected String Ticker;
	protected int ShareAmount;
	
	public Portfolio_Stock(int portfolio_Stock_Id)
	{
		this.Portfolio_Stock_Id = portfolio_Stock_Id;
	}
	
	public Portfolio_Stock(int portfolio_Id, String ticker, int shareAmount)
	{
		this.Portfolio_Id = portfolio_Id;
		this.Ticker = ticker;
		this.ShareAmount = shareAmount;
	}
	
	public Portfolio_Stock(int portfolio_Stock_Id,int portfolio_Id, String ticker, int shareAmount)
	{
		this.Portfolio_Stock_Id = portfolio_Stock_Id;
		this.Portfolio_Id = portfolio_Id;
		this.Ticker = ticker;
		this.ShareAmount = shareAmount;
	}

	public int getPortfolio_Stock_Id() {
		return Portfolio_Stock_Id;
	}

	public void setPortfolio_Stock_Id(int portfolio_Stock_Id) {
		Portfolio_Stock_Id = portfolio_Stock_Id;
	}

	public int getPortfolio_Id() {
		return Portfolio_Id;
	}

	public void setPortfolio_Id(int portfolio_Id) {
		Portfolio_Id = portfolio_Id;
	}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public int getShareAmount() {
		return ShareAmount;
	}

	public void setShareAmount(int shareAmount) {
		ShareAmount = shareAmount;
	}

	
}
