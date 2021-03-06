package dto;

public class QnaCommand {
	
	private String id;
	private String subject;
	private String content;
	
	public QnaCommand(String id, String subject, String content) {
		this.id = id;
		this.subject = subject;
		this.content = content;
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
}
