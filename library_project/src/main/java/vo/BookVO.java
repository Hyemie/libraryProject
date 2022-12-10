package vo;

public class BookVO {
	
	private int BookNum;
	private String Title;
	private String Writer;
	private String Publisher;
	private String Type;
	private String Year;
		
	public int getBookNum() {
		return BookNum;
	}

	public void setBookNum(int bookNum) {
		BookNum = bookNum;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	@Override
	public String toString() {
		return "BookVO [BookNum=" + BookNum + ", Title=" + Title + ", Writer=" + Writer + ", Publisher=" + Publisher
				+ ", Type=" + Type + ", Year=" + Year + "]";
	}
	
		
}
