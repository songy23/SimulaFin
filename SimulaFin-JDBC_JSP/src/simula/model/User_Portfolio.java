package simula.model;

public class User_Portfolio {
	
	protected int Portfolio_Id;
	protected String UserName;
	protected String Portfolio_Name;
	
	public User_Portfolio(int portfolio_Id, String userName, String portfolio_Name)
			{
				this.Portfolio_Id = portfolio_Id;
				this.UserName = userName;
				this.Portfolio_Name = portfolio_Name;
			}
	
	public User_Portfolio(String userName, String portfolio_Name)
	{
		this.UserName = userName;
		this.Portfolio_Name = portfolio_Name;
	}

	
	public User_Portfolio(int portfolio_Id)
	{
		this.Portfolio_Id = portfolio_Id;	}
	
	public User_Portfolio(){};

	public int getPortfolio_Id() {
		return Portfolio_Id;
	}

	public void setPortfolio_Id(int portfolio_Id) {
		Portfolio_Id = portfolio_Id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPortfolio_Name() {
		return Portfolio_Name;
	}

	public void setPortfolio_Name(String portfolio_Name) {
		Portfolio_Name = portfolio_Name;
	}
	
	

}
