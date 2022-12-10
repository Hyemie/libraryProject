package vo;

public class BrAdminVO {
	
	private int book_num;
	private int BrNum;
	private String BrTitle;
	private String BrUser;
	private String BrDate;
	private int BrStatus;
	private int BookCount;
	private String BrName;
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getBrNum() {
		return BrNum;
	}
	public void setBrNum(int brNum) {
		BrNum = brNum;
	}
	public String getBrTitle() {
		return BrTitle;
	}
	public void setBrTitle(String brTitle) {
		BrTitle = brTitle;
	}
	public String getBrUser() {
		return BrUser;
	}
	public void setBrUser(String brUser) {
		BrUser = brUser;
	}
	public String getBrDate() {
		return BrDate;
	}
	public void setBrDate(String brDate) {
		BrDate = brDate;
	}
	public int getBrStatus() {
		return BrStatus;
	}
	public void setBrStatus(int brStatus) {
		BrStatus = brStatus;
	}
	public int getBookCount() {
		return BookCount;
	}
	public void setBookCount(int bookCount) {
		BookCount = bookCount;
	}
	public String getBrName() {
		return BrName;
	}
	public void setBrName(String brName) {
		BrName = brName;
	}
	
	@Override
	public String toString() {
		return "BrAdminVO [book_num=" + book_num + ", BrNum=" + BrNum + ", BrTitle=" + BrTitle + ", BrUser=" + BrUser
				+ ", BrDate=" + BrDate + ", BrStatus=" + BrStatus + ", BookCount=" + BookCount + ", BrName=" + BrName
				+ "]";
	}

}
