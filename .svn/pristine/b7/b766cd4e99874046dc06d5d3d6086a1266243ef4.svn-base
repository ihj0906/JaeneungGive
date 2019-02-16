package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Donation;

public class MypageDao {
	
	DataSource dataSource;
	public MypageDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<Donation> myDonationList(String id) {
		ArrayList<Donation> mydonationList = new ArrayList<Donation>();
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
				Donation mydonation = new Donation();
				mydonation.setNo(rs.getInt("no"));
				mydonation.setTalent1(rs.getString("talent1"));
				mydonation.setTalent2(rs.getString("talent2"));
				mydonation.setPeople(rs.getInt("people"));
				mydonation.setId(rs.getString("id"));
				mydonation.setSubject(rs.getString("subject"));
				mydonation.setContent(rs.getString("content"));
				mydonation.setLocation(rs.getString("location"));
				mydonation.setClosing_date(rs.getString("closing_date"));
				mydonationList.add(mydonation);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
		return mydonationList;
	}

}
