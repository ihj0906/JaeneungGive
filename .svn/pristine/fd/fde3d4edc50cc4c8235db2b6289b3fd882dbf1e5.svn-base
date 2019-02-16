package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Faq;
import dto.Qna;
import dto.QnaCommand;

public class QnaDao {
	DataSource dataSource;

	public QnaDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int qnaWrite(QnaCommand qnaComn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into qna (id, subject, content, cre_date, rep_date) values (?,?,?,now(), now())";
		int result = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qnaComn.getId());
			pstmt.setString(2, qnaComn.getSubject());
			pstmt.setString(3, qnaComn.getContent());
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
		return result;
	}

	public ArrayList<Qna> qnaList(String id) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where id = ? order by no desc";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Qna qna = new Qna();
				qna.setNo(rs.getInt("no"));
				qna.setId(rs.getString("id"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setRepyn(rs.getInt("repyn"));
				qna.setReply(rs.getString("reply"));
				qna.setCre_date(rs.getTimestamp("cre_date"));
				qna.setRep_date(rs.getTimestamp("rep_date"));
				list.add(qna);
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

	public Qna qnaView(int no) {
		Qna qna = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where no = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qna = new Qna();
				qna.setId(rs.getString("id"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setRepyn(rs.getInt("repyn"));
				qna.setReply(rs.getString("reply"));
				qna.setCre_date(rs.getTimestamp("cre_date"));
				qna.setRep_date(rs.getTimestamp("rep_date"));
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
		return qna;
	}
	
	public ArrayList<Faq> faqList() {
		ArrayList<Faq> list = new ArrayList<Faq>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from faq";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Faq faq = new Faq();
				faq.setSubject(rs.getString("subject"));
				faq.setContent(rs.getString("content"));
				list.add(faq);
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

}
