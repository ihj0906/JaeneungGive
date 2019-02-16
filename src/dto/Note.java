package dto;

import java.sql.Timestamp;

public class Note {
	private int no;
	private String toId;
	private String fromId;
	private String content;
	private Timestamp sendTime;
	private int readYn;
	private int delTo;
	private int delFrom;
	
	public int getDelTo() {
		return delTo;
	}
	public void setDelTo(int delTo) {
		this.delTo = delTo;
	}
	public int getDelFrom() {
		return delFrom;
	}
	public void setDelFrom(int delFrom) {
		this.delFrom = delFrom;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public int getReadYn() {
		return readYn;
	}
	public void setReadYn(int readYn) {
		this.readYn = readYn;
	}
	
	
}
