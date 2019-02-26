package dto;

import java.sql.Timestamp;

public class Donation {
	private int no;
	private String talent1;
	private String talent2;
	private int people;
	private String id;
	private String subject;
	private String content;
	private String location;
	private String closing_date;
	private int app_progress;
	private String book_id;
	private int book_no;
	private Timestamp cre_date;
	private int count; // 기부 신청자 수

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTalent1() {
		return talent1;
	}

	public void setTalent1(String talent1) {
		this.talent1 = talent1;
	}

	public String getTalent2() {
		return talent2;
	}

	public void setTalent2(String talent2) {
		this.talent2 = talent2;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}
	public int getApp_progress() {
		return app_progress;
	}
	public void setApp_progress(int app_progress) {
		this.app_progress = app_progress;
	}
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	
	public Timestamp getCre_date() {
		return cre_date;
	}

	public void setCre_date(Timestamp cre_date) {
		this.cre_date = cre_date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
