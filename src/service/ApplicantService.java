package service;

import java.util.ArrayList;

import dao.ApplicantDao;
import dto.Applicant;

public class ApplicantService {
	
	private ApplicantDao applicantDao;

	public ApplicantService(ApplicantDao applicantDao) {
		this.applicantDao = applicantDao;
	}
	
	public int countOfApplicant(int board_id, int board_no) {
		return applicantDao.countOfApplicant(board_id, board_no);
	}
	public void addApplicant1(Applicant applicant) {
		applicantDao.addApplicant1(applicant);
	}
	public void addApplicant3(Applicant applicant) {
		applicantDao.addApplicant3(applicant);
	}
	
	
	public void delApplicant(int board_no, int board_id,String id) {
		applicantDao.delApplicant(board_no, board_id, id);
	}
	
	/**
	 * 
	 * @param board_no 게시물 번호 
	 * @param board_id 게시판 번호 ( 1 = 기부 , 2 = 교환 )
	 * @return
	 */
	public ArrayList<Applicant> listOfApplicant(int board_no, int board_id ){
		return applicantDao.listOfApplicant(board_no, board_id);
	}
	
	public Applicant applicant(int board_no, int board_id,String id) {
		return applicantDao.applicant(board_no, board_id, id);
	}
	
	public void confirmApplicant(Applicant applicant, int progress) {
		applicantDao.confirmApplicant(applicant,progress);
	}
	
}
