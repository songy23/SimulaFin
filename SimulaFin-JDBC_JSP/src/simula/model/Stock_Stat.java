package simula.model;

public class Stock_Stat {

	protected String Ticker;
	protected String Daily_range;
	protected String Yearly_range;
	protected float Open;
	protected String Vol_avg;
	protected String MktCap;
	protected float P_E;
	protected String Div_yield;
	protected float EPS;
	protected String Shares;
	protected float Beta;
	protected float InstOwn;
	
	public Stock_Stat() {};
	public Stock_Stat(String ticker, String Daily_range, String Yearly_range, float Open, String Vol_avg, String MktCap,
			float P_E, String Div_yield, float EPS, String Shares, float Beta, float InstOwn)
	{
		this.Ticker = ticker;
		this.Daily_range = Daily_range;
		this.Yearly_range = Yearly_range;
		this.Open = Open; 
		this.Vol_avg = Vol_avg;
		this.MktCap = MktCap;
		this.P_E = P_E;
		this.Div_yield = Div_yield;
		this.EPS = EPS;
		this.Shares = Shares;
		this.Beta = Beta;
		this.InstOwn = InstOwn;
	}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public String getDaily_range() {
		return Daily_range;
	}

	public void setDaily_range(String daily_range) {
		Daily_range = daily_range;
	}

	public String getYearly_range() {
		return Yearly_range;
	}

	public void setYearly_range(String yearly_range) {
		Yearly_range = yearly_range;
	}

	public float getOpen() {
		return Open;
	}

	public void setOpen(float open) {
		Open = open;
	}

	public String getVol_avg() {
		return Vol_avg;
	}

	public void setVol_avg(String vol_avg) {
		Vol_avg = vol_avg;
	}

	public String getMktCap() {
		return MktCap;
	}

	public void setMktCap(String mktCap) {
		MktCap = mktCap;
	}

	public float getP_E() {
		return P_E;
	}

	public void setP_E(float p_E) {
		P_E = p_E;
	}

	public String getDiv_yield() {
		return Div_yield;
	}

	public void setDiv_yield(String div_yield) {
		Div_yield = div_yield;
	}

	public float getEPS() {
		return EPS;
	}

	public void setEPS(float ePS) {
		EPS = ePS;
	}

	public String getShares() {
		return Shares;
	}

	public void setShares(String shares) {
		Shares = shares;
	}

	public float getBeta() {
		return Beta;
	}

	public void setBeta(float beta) {
		Beta = beta;
	}

	public float getInstOwn() {
		return InstOwn;
	}

	public void setInstOwn(float instOwn) {
		InstOwn = instOwn;
	}
	
	
}
