package vo;

import java.util.Date;

public class BrBookUserVO {
		
	private int UrNum;
	private String UrTitle;
	private Date UrDate;
	private int UrStatus;
	private int UrProgress;
	private int book_num;
	private String UrUser;
	
	public int getUrNum() {
		return UrNum;
	}
	public void setUrNum(int urNum) {
		UrNum = urNum;
	}
	public String getUrTitle() {
		return UrTitle;
	}
	public void setUrTitle(String urTitle) {
		UrTitle = urTitle;
	}
	public Date getUrDate() {
		return UrDate;
	}
	public void setUrDate(Date urDate) {
		UrDate = urDate;
	}
	public int getUrStatus() {
		return UrStatus;
	}
	public void setUrStatus(int urStatus) {
		UrStatus = urStatus;
	}
	public int getUrProgress() {
		return UrProgress;
	}
	public void setUrProgress(int urProgress) {
		UrProgress = urProgress;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getUrUser() {
		return UrUser;
	}
	public void setUrUser(String urUser) {
		UrUser = urUser;
	}
	
	
	@Override
	public String toString() {
		return "BrBookUserVO [UrNum=" + UrNum + ", UrTitle=" + UrTitle + ", UrDate=" + UrDate + ", UrStatus=" + UrStatus
				+ ", UrProgress=" + UrProgress + ", book_num=" + book_num + ", UrUser=" + UrUser + "]";
	}
	
}
