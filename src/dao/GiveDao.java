package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.AdminBoard;
import dto.Donation;
import dto.Exchange;
import dto.Location;

public class GiveDao {

	DataSource dataSource;

	public GiveDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 기부 목록
	public ArrayList<Donation> donationList() {
		ArrayList<Donation> donationList = new ArrayList<Donation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "select * from donation where concat_ws(talent1, talent2, subject, content, location) like '%" + keyword + "%' order by no desc";
		String sql = "SELECT d.*, count(a.board_no) as count FROM donation d left JOIN applicant a on d.no = a.board_no and a.board_id = 1 group by d.no ORDER BY d.no DESC";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setNo(rs.getInt("no"));
				donation.setTalent1(rs.getString("talent1"));
				donation.setTalent2(rs.getString("talent2"));
				donation.setPeople(rs.getInt("people"));
				donation.setId(rs.getString("id"));
				donation.setSubject(rs.getString("subject"));
				donation.setContent(rs.getString("content"));
				donation.setLocation(rs.getString("location"));
				donation.setClosing_date(rs.getString("closing_date"));
				donation.setCount(rs.getInt("count"));
				donation.setApp_progress(rs.getInt("app_progress"));
				donationList.add(donation);
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
		return donationList;
	}

	// 교환 목록
	public ArrayList<Exchange> exchangeList(String keyword, String id) {
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "select * from exchange where concat_ws(give_talent1, give_talent2, wish_talent1, wish_talent2, subject, content, location) like '%" + keyword + "%' order by no desc";
		String sql = "select e.* , b.id book_id from exchange e left join bookmark b on e.no = b.board_no and b.id=? where concat_ws(give_talent1, give_talent2, wish_talent1, wish_talent2, subject, content, location) like '%"
				+ keyword + "%' order by no desc";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Exchange exchange = new Exchange();
				exchange.setNo(rs.getInt("no"));
				exchange.setGive_talent1(rs.getString("give_talent1"));
				exchange.setGive_talent2(rs.getString("give_talent2"));
				exchange.setWish_talent1(rs.getString("wish_talent1"));
				exchange.setWish_talent2(rs.getString("wish_talent2"));
				exchange.setId(rs.getString("id"));
				exchange.setSubject(rs.getString("subject"));
				exchange.setContent(rs.getString("content"));
				exchange.setLocation(rs.getString("location"));
				exchange.setClosing_date(rs.getString("closing_date"));
				exchange.setBook_id(rs.getString("book_id"));
				exchangeList.add(exchange);
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
		return exchangeList;
	}

	// 새 기부 등록
	public void regDonationClass(Donation donation) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into donation(talent1, talent2, people, id, subject, content, location, closing_date) values (?,?,?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, donation.getTalent1());
			pstmt.setString(2, donation.getTalent2());
			pstmt.setInt(3, donation.getPeople());
			pstmt.setString(4, donation.getId());
			pstmt.setString(5, donation.getSubject());
			pstmt.setString(6, donation.getContent());
			pstmt.setString(7, donation.getLocation());
			pstmt.setString(8, donation.getClosing_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 새 교환 등록
	public void regExchangeClass(Exchange exchange) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into exchange(give_talent1, give_talent2, wish_talent1, wish_talent2, id, subject, content, location, closing_date) values (?,?,?,?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, exchange.getGive_talent1());
			pstmt.setString(2, exchange.getGive_talent2());
			pstmt.setString(3, exchange.getWish_talent1());
			pstmt.setString(4, exchange.getWish_talent2());
			pstmt.setString(5, exchange.getId());
			pstmt.setString(6, exchange.getSubject());
			pstmt.setString(7, exchange.getContent());
			pstmt.setString(8, exchange.getLocation());
			pstmt.setString(9, exchange.getClosing_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 기부 수정
	public void modDonationClass(Donation donation) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update donation set talent1=?,talent2=?,people=?,subject=?,content=?,location=?,closing_date=? where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, donation.getTalent1());
			pstmt.setString(2, donation.getTalent2());
			pstmt.setInt(3, donation.getPeople());
			pstmt.setString(4, donation.getSubject());
			pstmt.setString(5, donation.getContent());
			pstmt.setString(6, donation.getLocation());
			pstmt.setString(7, donation.getClosing_date());
			pstmt.setInt(8, donation.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 교환 수정
	public void modExchangeClass(Exchange exchange) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update exchange set give_talent1=?,give_talent2=?,wish_talent1=?,wish_talent2=?,subject=?,content=?,location=?,closing_date=? where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, exchange.getGive_talent1());
			pstmt.setString(2, exchange.getGive_talent2());
			pstmt.setString(3, exchange.getWish_talent1());
			pstmt.setString(4, exchange.getWish_talent2());
			pstmt.setString(5, exchange.getSubject());
			pstmt.setString(6, exchange.getContent());
			pstmt.setString(7, exchange.getLocation());
			pstmt.setString(8, exchange.getClosing_date());
			pstmt.setInt(9, exchange.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 기부 상세
	public Donation donationDetail(int no) {
		Donation donationDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from donation where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				donationDetail = new Donation();
				donationDetail.setNo(rs.getInt("no"));
				donationDetail.setTalent1(rs.getString("talent1"));
				donationDetail.setTalent2(rs.getString("talent2"));
				donationDetail.setPeople(rs.getInt("people"));
				donationDetail.setId(rs.getString("id"));
				donationDetail.setSubject(rs.getString("subject"));
				donationDetail.setContent(rs.getString("content"));
				donationDetail.setLocation(rs.getString("location"));
				donationDetail.setClosing_date(rs.getString("closing_date"));
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
		return donationDetail;
	}

	// 교환 상세
	public Exchange exchangeDetail(int no) {
		Exchange exchangeDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from exchange where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exchangeDetail = new Exchange();
				exchangeDetail.setNo(rs.getInt("no"));
				exchangeDetail.setGive_talent1(rs.getString("give_talent1"));
				exchangeDetail.setGive_talent2(rs.getString("give_talent2"));
				exchangeDetail.setWish_talent1(rs.getString("wish_talent1"));
				exchangeDetail.setWish_talent2(rs.getString("wish_talent2"));
				exchangeDetail.setId(rs.getString("id"));
				exchangeDetail.setSubject(rs.getString("subject"));
				exchangeDetail.setContent(rs.getString("content"));
				exchangeDetail.setLocation(rs.getString("location"));
				exchangeDetail.setClosing_date(rs.getString("closing_date"));
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
		return exchangeDetail;
	}

	// 기부 상세
	public Donation donationDetail(int no, String id) {
		Donation donationDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//			String sql = "select * from donation where no=?";
		String sql = "select d.* , b.id book_id from donation d left join bookmark b on d.no = b.board_no and b.id=? where d.no = ?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				donationDetail = new Donation();
				donationDetail.setNo(rs.getInt("no"));
				donationDetail.setTalent1(rs.getString("talent1"));
				donationDetail.setTalent2(rs.getString("talent2"));
				donationDetail.setPeople(rs.getInt("people"));
				donationDetail.setId(rs.getString("id"));
				donationDetail.setSubject(rs.getString("subject"));
				donationDetail.setContent(rs.getString("content"));
				donationDetail.setLocation(rs.getString("location"));
				donationDetail.setClosing_date(rs.getString("closing_date"));
				donationDetail.setBook_id(rs.getString("book_id"));
				donationDetail.setApp_progress(rs.getInt("app_progress"));
				
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
		return donationDetail;
	}

	// 교환 상세
	public Exchange exchangeDetail(int no, String id) {
		Exchange exchangeDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//				String sql = "select * from exchange where no=?";
		String sql = "select e.* , b.id book_id from exchange e left join bookmark b on e.no = b.board_no and b.id=? where e.no = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exchangeDetail = new Exchange();
				exchangeDetail.setNo(rs.getInt("no"));
				exchangeDetail.setGive_talent1(rs.getString("give_talent1"));
				exchangeDetail.setGive_talent2(rs.getString("give_talent2"));
				exchangeDetail.setWish_talent1(rs.getString("wish_talent1"));
				exchangeDetail.setWish_talent2(rs.getString("wish_talent2"));
				exchangeDetail.setId(rs.getString("id"));
				exchangeDetail.setSubject(rs.getString("subject"));
				exchangeDetail.setContent(rs.getString("content"));
				exchangeDetail.setLocation(rs.getString("location"));
				exchangeDetail.setClosing_date(rs.getString("closing_date"));
				exchangeDetail.setBook_id(rs.getString("book_id"));
				exchangeDetail.setApp_progress(rs.getInt("app_progress"));
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
		return exchangeDetail;
	}

	// 기부 삭제
	public void delDonationClass(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from donation where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 교환 삭제
	public void delExchangeClass(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from exchange where no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 관리자 기부/교환 목록
	public ArrayList<AdminBoard> adminBoardList() {
		ArrayList<AdminBoard> adminBoardList = new ArrayList<AdminBoard>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from adminboard order by cre_date desc";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminBoard adminBoard = new AdminBoard();
				adminBoard.setNo(rs.getInt("no"));
				adminBoard.setCategory(rs.getString("category"));
				adminBoard.setId(rs.getString("id"));
				adminBoard.setSubject(rs.getString("subject"));
				adminBoard.setContent(rs.getString("content"));
				adminBoard.setCre_date(rs.getTimestamp("cre_date"));
				adminBoardList.add(adminBoard);
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
		return adminBoardList;
	}

	// 관리자 기부/교환 상세페이지 출력
	public AdminBoard adminBoardDetail(int no, String category) {
		AdminBoard adminBoardDetail = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from adminboard where no=? and category=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, category);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminBoardDetail = new AdminBoard();
				adminBoardDetail.setNo(rs.getInt("no"));
				adminBoardDetail.setId(rs.getString("id"));
				adminBoardDetail.setCategory(rs.getString("category"));
				adminBoardDetail.setSubject(rs.getString("subject"));
				adminBoardDetail.setContent(rs.getString("content"));
				adminBoardDetail.setCre_date(rs.getTimestamp("cre_date"));
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
		return adminBoardDetail;
	}

	// 주소 찾기
	public ArrayList<Location> locationList(String lo) {
		ArrayList<Location> locationList = new ArrayList<Location>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from location where concat(lo1, lo2) like '%" + lo + "%'";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Location location = new Location();
				location.setLo1(rs.getString("lo1"));
				location.setLo2(rs.getString("lo2"));
				locationList.add(location);
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
		return locationList;
	}
	
	public void updateExchangeProgress(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update exchange set app_progress = 3 where no = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void updateDonationProgress(int progress, int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update donation set app_progress = ? where no = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, progress);
			pstmt.setInt(2, board_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public int donationCount(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as count from donation where concat_ws(talent1, talent2, subject, content, location) LIKE '%" + keyword + "%'  group by no";
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return count;

	}

	public int exchangeCount(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as count from exchange where concat_ws (give_talent1, give_talent2, wish_talent1, wish_talent2, subject, content, location) like '%"
		+ keyword + "%' ORDER BY no";
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return count;

	}

	// 기부 목록
	public ArrayList<Donation> donationList(int pagenum, int contentnum, String keyword, String id) {
		ArrayList<Donation> donationList = new ArrayList<Donation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT d.*, count(a.board_no) as count FROM donation d left JOIN applicant a on d.no = a.board_no and a.board_id = 1 WHERE concat_ws(talent1, talent2, subject, d.content, location) LIKE '%"
				+ keyword + "%'  group by d.no ORDER BY no DESC limit ?, ?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagenum);
			pstmt.setInt(2, contentnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setNo(rs.getInt("no"));
				donation.setTalent1(rs.getString("talent1"));
				donation.setTalent2(rs.getString("talent2"));
				donation.setPeople(rs.getInt("people"));
				donation.setId(rs.getString("id"));
				donation.setSubject(rs.getString("subject"));
				donation.setContent(rs.getString("content"));
				donation.setLocation(rs.getString("location"));
				donation.setClosing_date(rs.getString("closing_date"));
				donation.setCount(rs.getInt("count"));
				donation.setApp_progress(rs.getInt("app_progress"));
				donationList.add(donation);
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
		return donationList;
	}

	// 페이징 기능과 결합 된 교환 목록
	public ArrayList<Exchange> exchangeList(int pagenum, int contentnum, String keyword, String id) {
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//			String sql = "select e.* , b.id book_id from exchange e left join bookmark b on e.no = b.board_no and b.id=? where concat_ws(give_talent1, give_talent2, wish_talent1, wish_talent2, subject, content, location) like '%"
//					+ keyword + "%' group by e.no ORDER BY no DESC limit ?, ?";
		String sql = "select * from exchange where concat_ws(give_talent1, give_talent2, wish_talent1, wish_talent2, subject, content, location) like '%"
				+ keyword + "%' ORDER BY no DESC limit ?, ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagenum);
			pstmt.setInt(2, contentnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Exchange exchange = new Exchange();
				exchange.setNo(rs.getInt("no"));
				exchange.setGive_talent1(rs.getString("give_talent1"));
				exchange.setGive_talent2(rs.getString("give_talent2"));
				exchange.setWish_talent1(rs.getString("wish_talent1"));
				exchange.setWish_talent2(rs.getString("wish_talent2"));
				exchange.setId(rs.getString("id"));
				exchange.setSubject(rs.getString("subject"));
				exchange.setContent(rs.getString("content"));
				exchange.setLocation(rs.getString("location"));
				exchange.setClosing_date(rs.getString("closing_date"));
				exchangeList.add(exchange);
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
		return exchangeList;
	}

}

/*
 * // 기부 목록 - 전체 public ArrayList<Donation> adminDonationList(String keyword) {
 * ArrayList<Donation> adminDonationList = new ArrayList<Donation>(); Connection
 * conn = null; PreparedStatement pstmt = null; String sql =
 * "delete from donation where no=?"; try { conn = dataSource.getConnection();
 * pstmt = conn.prepareStatement(sql); pstmt.setInt(1, no);
 * pstmt.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally
 * { try { if (pstmt != null) pstmt.close(); if (conn != null) conn.close(); }
 * catch (Exception e) { } } }
 * 
 * 
 * }
 * 
 * /* // 기부 목록 - 전체 public ArrayList<Donation> donationList(String keyword) {
 * ArrayList<Donation> donationList = new ArrayList<Donation>(); Connection conn
 * = null; PreparedStatement pstmt = null; ResultSet rs = null; String sql =
 * "select * from donation where concat_ws(category, talent1, talent2, subject, content, location) like '%"
 * +keyword+"%'"; try { conn = dataSource.getConnection(); pstmt =
 * conn.prepareStatement(sql); // pstmt.setString(1, keyword); rs =
 * pstmt.executeQuery(); while (rs.next()) { Donation donation = new Donation();
 * donation.setNo(rs.getInt("no"));
 * donation.setTalent1(rs.getString("talent1"));
 * donation.setTalent2(rs.getString("talent2"));
 * donation.setPeople(rs.getInt("people")); donation.setId(rs.getString("id"));
 * donation.setSubject(rs.getString("subject"));
 * donation.setContent(rs.getString("content"));
 * donation.setLocation(rs.getString("location"));
 * donation.setClosing_date(rs.getString("closing_date"));
 * donationList.add(donation); } } catch(Exception e) { e.printStackTrace(); }
 * finally { try { if (rs != null) rs.close(); if (pstmt != null) pstmt.close();
 * if (conn != null) conn.close(); } catch(Exception e) {} } return
 * donationList; }
 */

/*
 * // 기부 목록 - 카테고리 별 public ArrayList<Donation> donationCategoryList(String
 * category) { ArrayList<Donation> donationCategoryList = new
 * ArrayList<Donation>(); Connection conn = null; PreparedStatement pstmt =
 * null; ResultSet rs = null; String sql =
 * "select * from donation where category=?"; try { conn =
 * dataSource.getConnection(); pstmt = conn.prepareStatement(sql);
 * pstmt.setString(1, category); rs = pstmt.executeQuery(); while (rs.next()) {
 * Donation donationCategory = new Donation();
 * donationCategory.setNo(rs.getInt("no"));
 * donationCategory.setCategory(rs.getString("category"));
 * donationCategory.setTalent1(rs.getString("talent1"));
 * donationCategory.setTalent2(rs.getString("talent2"));
 * donationCategory.setPeople(rs.getInt("people"));
 * donationCategory.setId(rs.getString("id"));
 * donationCategory.setSubject(rs.getString("subject"));
 * donationCategory.setContent(rs.getString("content"));
 * donationCategory.setLocation(rs.getString("location"));
 * donationCategory.setClosing_date(rs.getString("closing_date"));
 * donationCategoryList.add(donationCategory); } } catch(Exception e) {
 * e.printStackTrace(); } finally { try { if (rs != null) rs.close(); if (pstmt
 * != null) pstmt.close(); if (conn != null) conn.close(); } catch(Exception e)
 * {} } return donationCategoryList; }
 */
