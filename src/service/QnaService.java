package service;


import java.util.ArrayList;

import dao.QnaDao;
import dto.AdminFaqCommand;
import dto.AdminQnaWriteCommand;
import dto.Faq;
import dto.Qna;
import dto.QnaCommand;

public class QnaService {
	
	private QnaDao qnaDao;
		
	public QnaService(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}
	
	public int qnaWrite(QnaCommand qnaComn) {
		int result = qnaDao.qnaWrite(qnaComn);
		return result;
	}
	
	public ArrayList<Qna> qnaList(String id) {
		ArrayList<Qna> qnaList = qnaDao.qnaList(id);
		return qnaList;
	}
	
	public Qna qnaView(int no) {
		Qna qnaView = qnaDao.qnaView(no);
		return qnaView;
	}
	
//	admin faq 리스트 출력 
	public ArrayList<Faq> faqList() {
		ArrayList<Faq> faqList = qnaDao.faqList();
		return faqList;
	}
	
//	admin faq 등록
	public int adminFaqWrite(AdminFaqCommand adminFaqComm) {
		int result = qnaDao.adminFaqWrite(adminFaqComm);
		return result;
	}
	
//	admin faq 삭제
	public void adminFaqDelete(int no) {
		qnaDao.adminFaqDelete(no);
	}
	
//	admin qna 리스트 출력
	public ArrayList<Qna> adminQnaList(){
		ArrayList<Qna> adminQnaList = qnaDao.adminQnaList();
		return adminQnaList;
	}
	
//	admin qna 세부내용 출력
	public Qna adminQnaDetail(int no) {
		Qna adminQnaDetail = qnaDao.adminQnaDetail(no);
		return adminQnaDetail;
	}
	
//	admin qna 답변 등록
	public void adminQnaWrite(AdminQnaWriteCommand adminQnaWriteComm) {
		qnaDao.adminQnaWrite(adminQnaWriteComm);
	}
}
