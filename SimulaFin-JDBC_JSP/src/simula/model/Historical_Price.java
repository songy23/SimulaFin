package simula.model;

import java.util.Date;

public class Historical_Price {
	
	protected String Ticker;
	protected Date Date;
	protected float Open;
	protected float High;
	protected float Low;
	protected float Close;
	protected long Volume;
	
	public Historical_Price(String ticker, Date date, float open, float high, float low, float close, long volume)
			{
				this.Ticker = ticker;
				this.Date = date;
				this.Open = open;
				this.High = high;
				this.Low = low;
				this.Close = close;
				this.Volume = volume;
			}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public float getOpen() {
		return Open;
	}

	public void setOpen(float open) {
		Open = open;
	}

	public float getHigh() {
		return High;
	}

	public void setHigh(float high) {
		High = high;
	}

	public float getLow() {
		return Low;
	}

	public void setLow(float low) {
		Low = low;
	}

	public float getClose() {
		return Close;
	}

	public void setClose(float close) {
		Close = close;
	}

	public long getVolume() {
		return Volume;
	}

	public void setVolume(long volume) {
		Volume = volume;
	}
	

}
