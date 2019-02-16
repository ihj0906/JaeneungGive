package service;

import java.util.ArrayList;

import dao.MypageDao;
import dto.Donation;

public class MypageService {
	
	private MypageDao mypageDao;
	
	public MypageService(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}

	public ArrayList<Donation> myDonationList(String id) {
		ArrayList<Donation> myDonationList = mypageDao.myDonationList(id);
		return myDonationList;
	}

}
