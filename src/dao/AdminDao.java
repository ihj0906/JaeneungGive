package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import dto.Admin;

public class AdminDao {
	DataSource dataSource;
	
	public AdminDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
//	관리자 로그인
	public Admin selectId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from admin where id = ?";
		Admin admin = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setPassword(rs.getString("password"));
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
		return admin;
	}
	

}
