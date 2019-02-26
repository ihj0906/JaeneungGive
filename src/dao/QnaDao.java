package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.AdminFaqCommand;
import dto.AdminQnaWriteCommand;
import dto.Faq;
import dto.Qna;
import dto.QnaCommand;

public class QnaDao {
	DataSource dataSource;

	public QnaDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//	qna 입력 폼
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

//	qna 목록 출력
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

//	
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
	
//	faq 목록 출력 (+ admin faq 목록 출력)
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
				faq.setNo(rs.getInt("no"));
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
	
//	admin faq 입력 폼 
	public int adminFaqWrite(AdminFaqCommand adminFaqComm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into faq (subject, content) values (?, ?)";
		int result = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminFaqComm.getSubject());
			pstmt.setString(2, adminFaqComm.getContent());
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
	
//	admin faq 삭제
	public void adminFaqDelete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from faq where no = ?";
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
	
//	admin qna 리스트 출력
	public ArrayList<Qna> adminQnaList(){
		ArrayList<Qna> adminQnaList = new ArrayList<Qna>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Qna adminQna = new Qna();
				adminQna.setNo(rs.getInt("no"));
				adminQna.setId(rs.getString("id"));
				adminQna.setSubject(rs.getString("subject"));
				adminQna.setContent(rs.getString("content"));
				adminQna.setCre_date(rs.getTimestamp("cre_date"));
				adminQna.setRepyn(rs.getInt("repyn"));
				adminQnaList.add(adminQna);
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
		return adminQnaList;
	}
	
//	admin qna 상세목록 출력
	public Qna adminQnaDetail(int no) {
		Qna qna = new Qna();
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
				qna.setNo(rs.getInt("no"));
				qna.setId(rs.getString("id"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setCre_date(rs.getTimestamp("cre_date"));
				qna.setReply(rs.getString("reply"));
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
			} catch(Exception e) {
			}
		}
		return qna;
	}
	
//	admin qna 답변 등록
	public int adminQnaWrite(AdminQnaWriteCommand adminQnaWriteComm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update qna set reply=?, repyn=1 where no=?";
		int result = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminQnaWriteComm.getReply());
			pstmt.setInt(2, adminQnaWriteComm.getNo());
			pstmt.executeUpdate();
		} catch(Exception e) {
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

}
