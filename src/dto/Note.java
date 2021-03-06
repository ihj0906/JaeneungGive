package dto;

import java.sql.Timestamp;

public class Note {
	private int no;				// 쪽지 번호
	private String toId;		// 받는사람 ID
	private String fromId;		// 보낸사람 ID
	private String content;		// 쪽지 내용
	private Timestamp sendTime;	// 보낸 날짜
	private int readYn;			// 읽은상태 ( 1 읽음 2 읽지 않음)
	private int delTo;			// 쪽지삭제여부 - 받은사람 ( 1 삭제 2 삭제안함)
	private int delFrom;		// 쪽지삭제여부 - 보낸사람  ( 1 삭제 2 삭제안함)
	
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
