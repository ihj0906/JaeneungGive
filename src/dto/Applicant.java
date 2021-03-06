package dto;

import java.sql.Timestamp;

public class Applicant {
	private int no;					// 신청번호
	private String id;				// 신청자 ID
	private Timestamp appli_date; 	// 신청일
	private String content;			// 신청내용
	private int progress;			// 진행상태 (1 진행중 2 완료(승인) 3 거절)
	private int board_no;			// 게시물 번호 
	private int board_id;			// 게시판 번호 (1 기부 2 교환)
	private String subject;			// 게시물 제목
//	private int count;				// 전체 신청자 수 
	
	/*public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}*/
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getAppli_date() {
		return appli_date;
	}
	public void setAppli_date(Timestamp appli_date) {
		this.appli_date = appli_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	
}
