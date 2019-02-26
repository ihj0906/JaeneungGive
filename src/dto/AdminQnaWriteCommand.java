package dto;

public class AdminQnaWriteCommand {
	
	private int no;			// 글번호
	private int repyn;		// 진행상태
	private String reply;	// 답변
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRepyn() {
		return repyn;
	}
	public void setRepyn(int repyn) {
		this.repyn = repyn;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
