package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Applicant;

public class ApplicantDao {

	private DataSource dataSource;

	public ApplicantDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int countOfApplicant(int board_id, int board_no) {
		int resultOfCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as count from applicant where board_id=? and board_no=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			pstmt.setInt(2, board_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultOfCount = rs.getInt("count");
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
		return resultOfCount;
	}

	public void addApplicant1(Applicant applicant) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into applicant (id, content, progress, board_no, board_id) values (?, ?, 1, ?, ?) ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, applicant.getId());
			pstmt.setString(2, applicant.getContent());
			pstmt.setInt(3, applicant.getBoard_no());
			pstmt.setInt(4, applicant.getBoard_id());
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
	
	public void addApplicant3(Applicant applicant) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into applicant (id, content, progress, board_no, board_id) values (?, ?, 3, ?, ?) ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, applicant.getId());
			pstmt.setString(2, applicant.getContent());
			pstmt.setInt(3, applicant.getBoard_no());
			pstmt.setInt(4, applicant.getBoard_id());
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

	public void delApplicant(int board_no, int board_id, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from applicant where board_no =? and board_id = ? and id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.setInt(2, board_id);
			pstmt.setString(3, id);
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

	public ArrayList<Applicant> listOfApplicant(int board_no, int board_id) {
		ArrayList<Applicant> listOfApplicant = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from applicant where board_no = ? and board_id = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.setInt(2, board_id);
			rs = pstmt.executeQuery();
			int num = 0;
			while (rs.next()) {
				++num;
				Applicant applicant = new Applicant();
				applicant.setNo(num);
				applicant.setId(rs.getString("id"));
				applicant.setAppli_date(rs.getTimestamp("appli_date"));
				applicant.setContent(rs.getString("content"));
				applicant.setProgress(rs.getInt("progress"));
				applicant.setBoard_no(rs.getInt("board_no"));
				applicant.setBoard_id(rs.getInt("board_id"));
				listOfApplicant.add(applicant);
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
		return listOfApplicant;
	}

	public Applicant applicant(int board_no, int board_id, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Applicant applicant = null;
		String sql = "select * from applicant where board_no = ? and board_id = ? and id = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.setInt(2, board_id);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				applicant = new Applicant();
				applicant.setNo(rs.getInt("no"));
				applicant.setId(rs.getString("id"));
				applicant.setAppli_date(rs.getTimestamp("appli_date"));
				applicant.setContent(rs.getString("content"));
				applicant.setProgress(rs.getInt("progress"));
				applicant.setBoard_no(rs.getInt("board_no"));
				applicant.setBoard_id(rs.getInt("board_id"));
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
		return applicant;
	}

	public void confirmApplicant(Applicant applicant, int progress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update applicant set progress = ? where board_no =? and board_id = ? and id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, progress);
			pstmt.setInt(2, applicant.getBoard_no());
			pstmt.setInt(3, applicant.getBoard_id());
			pstmt.setString(4, applicant.getId());
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

}
