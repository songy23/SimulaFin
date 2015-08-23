package simula.model;

public class Stock {

	protected String Ticker;
	protected String Industry;
	protected String Description;
	
	public Stock() {};
	
	public Stock(String Ticker, String Industry, String Description)
			{
				this.Ticker = Ticker;
				this.Industry = Industry;
				this.Description = Description;
			}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
