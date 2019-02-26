package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Applicant_d;
import dto.Applicant_e;
import dto.Donation;
import dto.Exchange;

public class MypageDao {

	DataSource dataSource;

	public MypageDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 마이페이지 내가 작성한 기부 목록 가져오기
	public ArrayList<Donation> mywriteDonationList(String id) {
		ArrayList<Donation> mywriteDonationList = new ArrayList<Donation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from donation where id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation mywriteDonation = new Donation();
				mywriteDonation.setNo(rs.getInt("no"));
				mywriteDonation.setTalent1(rs.getString("talent1"));
				mywriteDonation.setTalent2(rs.getString("talent2"));
				mywriteDonation.setPeople(rs.getInt("people"));
				mywriteDonation.setId(rs.getString("id"));
				mywriteDonation.setSubject(rs.getString("subject"));
				mywriteDonation.setContent(rs.getString("content"));
				mywriteDonation.setLocation(rs.getString("location"));
				mywriteDonation.setClosing_date(rs.getString("closing_date"));
				mywriteDonation.setApp_progress(rs.getInt("app_progress"));
				mywriteDonationList.add(mywriteDonation);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return mywriteDonationList;
	}

	// 내가 작성한 교환 목록 가져오기
	public ArrayList<Exchange> mywriteExchangeList(String id) {
		ArrayList<Exchange> mywriteExchangeList = new ArrayList<Exchange>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from exchange where id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Exchange mywriteExchange = new Exchange();
				mywriteExchange.setNo(rs.getInt("no"));
				mywriteExchange.setGive_talent1(rs.getString("give_talent1"));
				mywriteExchange.setGive_talent2(rs.getString("give_talent2"));
				mywriteExchange.setWish_talent1(rs.getString("wish_talent1"));
				mywriteExchange.setWish_talent2(rs.getString("wish_talent2"));
				mywriteExchange.setId(rs.getString("id"));
				mywriteExchange.setSubject(rs.getString("subject"));
				mywriteExchange.setContent(rs.getString("content"));
				mywriteExchange.setLocation(rs.getString("location"));
				mywriteExchange.setClosing_date(rs.getString("closing_date"));
				mywriteExchange.setApp_progress(rs.getInt("app_progress"));
				mywriteExchangeList.add(mywriteExchange);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return mywriteExchangeList;
}

	// 내가 북마크한 기부목록 가져오기
	public ArrayList<Donation> bmDonationList(String id) {
		ArrayList<Donation> bmDonationList = new ArrayList<Donation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bookmark_d where book_id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation bmDonation = new Donation();
				bmDonation.setNo(rs.getInt("no"));
				bmDonation.setTalent1(rs.getString("talent1"));
				bmDonation.setTalent2(rs.getString("talent2"));
				bmDonation.setPeople(rs.getInt("people"));
				bmDonation.setId(rs.getString("id"));
				bmDonation.setSubject(rs.getString("subject"));
				bmDonation.setContent(rs.getString("content"));
				bmDonation.setLocation(rs.getString("location"));
				bmDonation.setClosing_date(rs.getString("closing_date"));
				bmDonationList.add(bmDonation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return bmDonationList;
	}

	// 내가 북마크한 교환 목록 가져오기
	public ArrayList<Exchange> bmExchangeList(String id) {
		ArrayList<Exchange> bmExchangeList = new ArrayList<Exchange>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bookmark_e where book_id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Exchange bmExchange = new Exchange();
				bmExchange.setNo(rs.getInt("no"));
				bmExchange.setGive_talent1(rs.getString("give_talent1"));
				bmExchange.setGive_talent2(rs.getString("give_talent2"));
				bmExchange.setWish_talent1(rs.getString("wish_talent1"));
				bmExchange.setWish_talent2(rs.getString("wish_talent2"));
				bmExchange.setId(rs.getString("id"));
				bmExchange.setSubject(rs.getString("subject"));
				bmExchange.setContent(rs.getString("content"));
				bmExchange.setLocation(rs.getString("location"));
				bmExchange.setClosing_date(rs.getString("closing_date"));
				bmExchangeList.add(bmExchange);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return bmExchangeList;
	}

	// 내가 신청한 기부목록 가져오기
	public ArrayList<Applicant_d> myApplyDonationList(String id) {
		ArrayList<Applicant_d> myApplyDonationList = new ArrayList<Applicant_d>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from applicant_d where app_id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Applicant_d myApplyDonation = new Applicant_d();
				myApplyDonation.setNo(rs.getInt("no"));
				myApplyDonation.setTalent1(rs.getString("talent1"));
				myApplyDonation.setTalent2(rs.getString("talent2"));
				myApplyDonation.setPeople(rs.getInt("people"));
				myApplyDonation.setId(rs.getString("id"));
				myApplyDonation.setSubject(rs.getString("subject"));
				myApplyDonation.setContent(rs.getString("content"));
				myApplyDonation.setLocation(rs.getString("location"));
				myApplyDonation.setClosing_date(rs.getString("closing_date"));
				myApplyDonation.setApp_id(rs.getString("app_id"));
				myApplyDonation.setApp_appli_date(rs.getTimestamp("app_appli_date"));
				myApplyDonation.setApp_progress(rs.getInt("app_progress"));
				myApplyDonation.setApp_user_progress(rs.getInt("app_user_progress"));
				myApplyDonationList.add(myApplyDonation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return myApplyDonationList;
	}

	// 내가 신청한 교환목록 가져오기
	public ArrayList<Applicant_e> myApplyExchangeList(String id) {
		ArrayList<Applicant_e> myApplyExchangeList = new ArrayList<Applicant_e>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from applicant_e where app_id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Applicant_e myApplyExchange = new Applicant_e();
				myApplyExchange.setNo(rs.getInt("no"));
				myApplyExchange.setGive_talent1(rs.getString("give_talent1"));
				myApplyExchange.setGive_talent2(rs.getString("give_talent2"));
				myApplyExchange.setWish_talent1(rs.getString("wish_talent1"));
				myApplyExchange.setWish_talent2(rs.getString("wish_talent2"));
				myApplyExchange.setId(rs.getString("id"));
				myApplyExchange.setSubject(rs.getString("subject"));
				myApplyExchange.setContent(rs.getString("content"));
				myApplyExchange.setLocation(rs.getString("location"));
				myApplyExchange.setClosing_date(rs.getString("closing_date"));
				myApplyExchange.setApp_progress(rs.getInt("app_progress"));
				myApplyExchange.setApp_id(rs.getString("app_id"));
				myApplyExchange.setApp_appli_date(rs.getTimestamp("app_appli_date"));
				myApplyExchange.setApp_user_progress(rs.getInt("app_user_progress"));
				myApplyExchangeList.add(myApplyExchange);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return myApplyExchangeList;
	}
}
