package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Bookmark;

public class BookmarkDao {
	private DataSource dataSource;

	public BookmarkDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 해당 게시물에 북마크된 정보가 있는지 확인
	 * 
	 * @param id       로그인한 사용자ID
	 * @param board_no 게시물번호
	 * @param board_id 게시판 번호 (1 = 기부 / 2 = 교환)
	 * @return 북마크가 되어 있으면 1, 없으면 0 리턴
	 */
	public Bookmark checkBookmark(String id, String board_name, int board_no, int board_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bookmark bookmark = null;
		String sql = "SELECT d.*, b.* FROM "+board_name+" d LEFT JOIN bookmark b ON d.no = b.board_no and b.board_id =? and b.id=? where d.no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			pstmt.setString(2, id);
			pstmt.setInt(3, board_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bookmark = new Bookmark();
				bookmark.setNo(rs.getInt("d.no"));
				bookmark.setId(rs.getString("b.id"));
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
		return bookmark;
	}

	/**
	 * 북마크 된 정보를 삭제한다
	 * 
	 * @param id       로그인한 사용자ID
	 * @param board_no 게시물번호
	 * @param board_id 게시판 번호 (1 = 기부 / 2 = 교환)
	 */
	public void removeBookmark(String id, int board_no, int board_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from bookmark where id = ? and board_no = ? and board_id =?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, board_no);
			pstmt.setInt(3, board_id);
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

	/**
	 * 북마크를 추가한다
	 * 
	 * @param id       로그인한 사용자ID
	 * @param board_no 게시물번호
	 * @param board_id 게시판 번호 (1 = 기부 / 2 = 교환)
	 */
	public void addBookmark(String id, int board_no, int board_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into bookmark (id, board_no, board_id) values (?,?,?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, board_no);
			pstmt.setInt(3, board_id);
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

	public ArrayList<Bookmark> listOfBookmark(String board_name, int pagenum, int contentnum, int board_id, String id) {
		ArrayList<Bookmark> list = new ArrayList<Bookmark>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT d.no, b.id FROM "+board_name+" d LEFT JOIN bookmark b ON d.no = b.board_no AND b.board_id=? and b.id=? ORDER BY d.no DESC limit ?, ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			pstmt.setString(2, id);
			pstmt.setInt(3, pagenum);
			pstmt.setInt(4, contentnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bookmark bookmark = new Bookmark();
				bookmark.setNo(rs.getInt("no"));
				bookmark.setId(rs.getString("id"));
				list.add(bookmark);
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
		return list;
	}
	
	
	/*
	*//**
		 * 사용자가 로그인할 경우 인덱스 페이지에 사용할 기부글 목록을 가져오는데 사용
		 * 
		 * @param id 로그인한 사용자 ID
		 * @return 사용자가 북마크한 정보가 포함 된 기부글 목록
		 */
	/*
	 * public ArrayList<Donation> indexDonationList(String id) { ArrayList<Donation>
	 * list = new ArrayList<Donation>(); Connection conn = null; PreparedStatement
	 * pstmt = null; ResultSet rs = null; String sql =
	 * "select d.* , b.id book_id, b.no book_no from donation d left join bookmark b on d.no = b.board_no and b.id =? order by no desc"
	 * ; try { conn = dataSource.getConnection(); pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery(); while (rs.next()) { Donation donation = new Donation();
	 * donation.setNo(rs.getInt("no"));
	 * donation.setTalent1(rs.getString("talent1"));
	 * donation.setTalent2(rs.getString("talent2"));
	 * donation.setPeople(rs.getInt("people")); donation.setId(rs.getString("id"));
	 * donation.setSubject(rs.getString("subject"));
	 * donation.setContent(rs.getString("content"));
	 * donation.setLocation(rs.getString("location"));
	 * donation.setClosing_date(rs.getString("closing_date"));
	 * donation.setBook_id(rs.getString("book_id"));
	 * donation.setBook_no(rs.getInt("book_no")); list.add(donation); } } catch
	 * (Exception e) { e.printStackTrace(); } finally { try { if (rs != null)
	 * rs.close(); if (pstmt != null) pstmt.close(); if (conn != null) conn.close();
	 * } catch (Exception e) {
	 * 
	 * } } return list; }
	 * 
	 *//**
		 * 사용자가 로그인할 경우 인덱스 페이지에 최근 교환글 목록을 가져오는데 사용 게시판DB와 북마크DB 중 게시물번호가 일치하며, 북마크ID가
		 * 사용자 ID 및 null 인 값
		 * 
		 * @param id 로그인한 사용자 ID
		 * @return 사용자가 북마크한 정보가 포함 된 교환글 목록
		 *//*
			 * public ArrayList<Exchange> indexExchangeList(String id) { ArrayList<Exchange>
			 * list = new ArrayList<Exchange>(); Connection conn = null; PreparedStatement
			 * pstmt = null; ResultSet rs = null; String sql =
			 * "select e.* , b.id book_id, b.no book_no from exchange e left join bookmark b on e.no = b.board_no and b.id =? order by no desc;"
			 * ; try { conn = dataSource.getConnection(); pstmt =
			 * conn.prepareStatement(sql); pstmt.setString(1, id); rs =
			 * pstmt.executeQuery(); while (rs.next()) { Exchange exchange = new Exchange();
			 * exchange.setNo(rs.getInt("no"));
			 * exchange.setGive_talent1(rs.getString("give_talent1"));
			 * exchange.setGive_talent2(rs.getString("give_talent2"));
			 * exchange.setWish_talent1(rs.getString("wish_talent1"));
			 * exchange.setWish_talent2(rs.getString("wish_talent2"));
			 * exchange.setId(rs.getString("id"));
			 * exchange.setSubject(rs.getString("subject"));
			 * exchange.setContent(rs.getString("content"));
			 * exchange.setLocation(rs.getString("location"));
			 * exchange.setClosing_date(rs.getString("closing_date"));
			 * exchange.setBook_id(rs.getString("book_id"));
			 * exchange.setBook_no(rs.getInt("book_no")); list.add(exchange); } } catch
			 * (Exception e) { e.printStackTrace(); } finally { try { if (rs != null)
			 * rs.close(); if (pstmt != null) pstmt.close(); if (conn != null) conn.close();
			 * } catch (Exception e) {
			 * 
			 * } } return list; }
			 */
}
