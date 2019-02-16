/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Faq;

public class FaqDao {
	DataSource dataSource;
	
	public FaqDao(DataSource dataSource) {
		this.dataSource = dataSource;
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
*/