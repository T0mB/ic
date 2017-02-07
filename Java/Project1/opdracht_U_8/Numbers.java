package opdracht_U_8;

public class Numbers {
	private String date;
	private String standard;
	private String high;
	private String low;
	private String close;
	private String volume;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String string) {
		this.high = string;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String toString(){
		return String.valueOf(high);
	}
}
