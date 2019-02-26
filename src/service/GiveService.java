package service;

import java.util.ArrayList;

import dao.GiveDao;
import dto.AdminBoard;
import dto.Donation;
import dto.Exchange;
import dto.Location;

public class GiveService {

	private GiveDao giveDao;

	public GiveService(GiveDao giveDao) {
		this.giveDao = giveDao;
	}

	// admin 기부/교환 목록 - 전체
	public ArrayList<AdminBoard> adminBoardList() {
		ArrayList<AdminBoard> adminBoardList = giveDao.adminBoardList();
		return adminBoardList;
	}

	// admin 기부/교환 상세페이지 출력
	public AdminBoard adminBoardDetail(int no, String category) {
		AdminBoard adminBoardDetail = giveDao.adminBoardDetail(no, category);
		return adminBoardDetail;
	}

	/*
	 * // 기부 목록 - 카테고리 별 public ArrayList<Donation> donationCategoryList(String
	 * category) { ArrayList<Donation> donationCategoryList =
	 * giveDao.donationCategoryList(category); return donationCategoryList; }
	 */

	// 기부 목록 - 검색결과 별
	public ArrayList<Donation> donationList(int pagenum, int contentnum, String keyword, String id) {
		return giveDao.donationList(pagenum, contentnum, keyword, id);
	}

	public ArrayList<Donation> donationList() {
		return giveDao.donationList();
	}

	// 교환 목록 - 검색결과 별
	public ArrayList<Exchange> exchangeList(int pagenum, int contentnum, String keyword, String id) {
		return giveDao.exchangeList(pagenum, contentnum, keyword, id);
	}
	
	// 교환 목록 - 검색결과 별
	public ArrayList<Exchange> exchangeList(String keyword, String id) {
		return giveDao.exchangeList(keyword, id);
	}

	// 새 기부 등록
	public void regDonationClass(Donation donation) {
		giveDao.regDonationClass(donation);
	}

	// 새 교환 등록
	public void regExchangeClass(Exchange exchange) {
		giveDao.regExchangeClass(exchange);
	}

	// 기부 상세
	public Donation donationDetail(int no, String id) {
		return giveDao.donationDetail(no, id);
	}

	// 교환 상세
	public Exchange exchangeDetail(int no, String id) {
		return giveDao.exchangeDetail(no, id);
	}

	// 기부 상세
	public Donation donationDetail(int no) {
		return giveDao.donationDetail(no);
	}

	// 교환 상세
	public Exchange exchangeDetail(int no) {
		return giveDao.exchangeDetail(no);
	}

	// 기부 수정
	public void modDonationClass(Donation donation) {
		giveDao.modDonationClass(donation);
	}

	// 교환 수정
	public void modExchangeClass(Exchange exchange) {
		giveDao.modExchangeClass(exchange);
	}

	// 기부 삭제
	public void delDonationClass(int no) {
		giveDao.delDonationClass(no);
	}

	// 교환 삭제
	public void delExchangeClass(int no) {
		giveDao.delExchangeClass(no);
	}

	// 주소 찾기
	public ArrayList<Location> locationList(String lo) {
		return giveDao.locationList(lo);
	}

	// "진행중(1) : 작성 후 ~ 마감/완료 전까지 // 마감(2) : 1) 작성자가 마감버튼 클릭 시, 2) 마감일이 지났을 경우 //
	// 완료(3) : 총인원=신청인원 일 경우"
	public void updateExchangeProgress(int board_no) {
		giveDao.updateExchangeProgress(board_no);
	}
	
	// "진행중(1) : 작성 후 ~ 마감/완료 전까지 // 마감(2) : 1) 작성자가 마감버튼 클릭 시, 2) 마감일이 지났을 경우 //
	// 완료(3) : 총인원=신청인원 일 경우"
	public void updateDonationProgress(int progress, int board_no) {
		giveDao.updateDonationProgress(progress, board_no);
	}

	public int donationCount(String keyword) {
		return giveDao.donationCount(keyword);
	}
	public int exchangeCount(String keyword) {
		return giveDao.exchangeCount(keyword);
	}

	/*
	 * public ArrayList<Donation> testlist(int pagenum, int contentnum) { return
	 * giveDao.testlist(pagenum, contentnum); }
	 */

	/*
	 * public List<Donation> listAll(String searchOption, String keyword) throws
	 * Exception { return giveDao.listAll(searchOption, keyword); }
	 * 
	 * public int countArticle(String searchOption, String keyword) throws Exception
	 * { return giveDao.countArticle(searchOption, keyword); }
	 */

}
