package vo;

public class RegBookVO {
	
	private int RNum;
	private String RTitle;
	private String RWriter;
	private String RPublisher;
	private String RReason;
	private int RPrice;
	private String REtc;
	private int RState;
	
	public int getRNum() {
		return RNum;
	}
	public void setRNum(int rNum) {
		RNum = rNum;
	}
	public String getRTitle() {
		return RTitle;
	}
	public void setRTitle(String rTitle) {
		RTitle = rTitle;
	}
	public String getRWriter() {
		return RWriter;
	}
	public void setRWriter(String rWriter) {
		RWriter = rWriter;
	}
	public String getRPublisher() {
		return RPublisher;
	}
	public void setRPublisher(String rPublisher) {
		RPublisher = rPublisher;
	}
	public String getRReason() {
		return RReason;
	}
	public void setRReason(String rReason) {
		RReason = rReason;
	}
	public int getRPrice() {
		return RPrice;
	}
	public void setRPrice(int rPrice) {
		RPrice = rPrice;
	}
	public String getREtc() {
		return REtc;
	}
	public void setREtc(String rEtc) {
		REtc = rEtc;
	}
	public int getRState() {
		return RState;
	}
	public void setRState(int rState) {
		RState = rState;
	}
	
	@Override
	public String toString() {
		return "RegBookVO [RNum=" + RNum + ", RTitle=" + RTitle + ", RWriter=" + RWriter + ", RPublisher=" + RPublisher
				+ ", RReason=" + RReason + ", RPrice=" + RPrice + ", REtc=" + REtc + ", RState=" + RState + "]";
	}

}