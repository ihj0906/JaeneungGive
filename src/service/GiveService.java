package service;

import java.util.ArrayList;

import dao.GiveDao;
import dto.Donation;
import dto.Exchange;

public class GiveService {
	
	private GiveDao giveDao;
	
	public GiveService(GiveDao giveDao) {
		this.giveDao = giveDao;
	}
	
	
	/*// 기부 목록 - 전체
	public ArrayList<Donation> donationList() {
		ArrayList<Donation> donationList = giveDao.donationList();
		return donationList;
	}
	// 기부 목록 - 카테고리 별
	public ArrayList<Donation> donationCategoryList(String category) {
		ArrayList<Donation> donationCategoryList = giveDao.donationCategoryList(category);
		return donationCategoryList;
	}*/

	
	// 기부 목록 - 검색결과 별
	public ArrayList<Donation> donationList(String keyword) {
		ArrayList<Donation> donationList = null;
		donationList = giveDao.donationList(keyword);
		return donationList;
	}
	// 교환 목록 - 검색결과 별
	public ArrayList<Exchange> exchangeList(String keyword) {
		ArrayList<Exchange> exchangeList = null;
		exchangeList = giveDao.exchangeList(keyword);
		return exchangeList;
	}
	
	// 새 기부 클래스 등록
	public int regDonationClass(Donation donation) {
		int result = giveDao.regDonationClass(donation);
		return result;
	}
	// 기부 상세
	public Donation donationDetail(int no) {
		Donation donation = giveDao.donationDetail(no);
		return donation;
	}
	
/*	public List<Donation> listAll(String searchOption, String keyword) throws Exception {
		return giveDao.listAll(searchOption, keyword);
	}
	
	public int countArticle(String searchOption, String keyword) throws Exception {
		return giveDao.countArticle(searchOption, keyword);
	}*/
	
	
	
}
