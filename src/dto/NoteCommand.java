package dto;

public class NoteCommand {
	private String toId;		// 받는사람 ID
	private String fromId;		// 보낸사람 ID
	private String content;		// 쪽지 내용
	
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
	
	
}
