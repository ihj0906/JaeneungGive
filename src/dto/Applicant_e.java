package dto;

import java.sql.Timestamp;

public class Applicant_e {
	private int no;
	private String give_talent1;
	private String give_talent2;
	private String wish_talent1;
	private String wish_talent2;
	private int people;
	private String id;
	private String subject;
	private String content;
	private String location;
	private String closing_date;
	private String app_id;
	private Timestamp app_appli_date;
	private int app_progress;
	private int app_user_progress;
	
	
	
	public int getApp_user_progress() {
		return app_user_progress;
	}
	public void setApp_user_progress(int app_user_progress) {
		this.app_user_progress = app_user_progress;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getGive_talent1() {
		return give_talent1;
	}
	public void setGive_talent1(String give_talent1) {
		this.give_talent1 = give_talent1;
	}
	public String getGive_talent2() {
		return give_talent2;
	}
	public void setGive_talent2(String give_talent2) {
		this.give_talent2 = give_talent2;
	}
	public String getWish_talent1() {
		return wish_talent1;
	}
	public void setWish_talent1(String wish_talent1) {
		this.wish_talent1 = wish_talent1;
	}
	public String getWish_talent2() {
		return wish_talent2;
	}
	public void setWish_talent2(String wish_talent2) {
		this.wish_talent2 = wish_talent2;
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
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public Timestamp getApp_appli_date() {
		return app_appli_date;
	}
	public void setApp_appli_date(Timestamp app_appli_date) {
		this.app_appli_date = app_appli_date;
	}
	public int getApp_progress() {
		return app_progress;
	}
	public void setApp_progress(int app_progress) {
		this.app_progress = app_progress;
	}

	
}
