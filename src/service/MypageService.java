package service;

import java.util.ArrayList;

import dao.MypageDao;
import dto.Applicant_d;
import dto.Applicant_e;
import dto.Donation;
import dto.Exchange;

public class MypageService {

	private MypageDao mypageDao;

	public MypageService(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}

	public ArrayList<Donation> mywriteDonationList(String id) {
		return mypageDao.mywriteDonationList(id);

	}
	public ArrayList<Exchange> mywriteExchangeList(String id) {
		return mypageDao.mywriteExchangeList(id);

	}
	public ArrayList<Donation> bmDonationList(String id) {
		return mypageDao.bmDonationList(id);
	}

	public ArrayList<Exchange> bmExchangeList(String id) {
		return mypageDao.bmExchangeList(id);
	}

	public ArrayList<Applicant_d> myApplyDonationList(String id) {
		return mypageDao.myApplyDonationList(id);
	}

	public ArrayList<Applicant_e> myApplyExchangeList(String id) {
		return mypageDao.myApplyExchangeList(id);
	}
}
