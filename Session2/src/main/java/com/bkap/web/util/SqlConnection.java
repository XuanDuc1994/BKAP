package com.bkap.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bkap.web.entity.Category;
import com.bkap.web.entity.IEntity;

public class SqlConnection {
	public static Connection open() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Travel_Management", "sa", "1234$");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// "SELECT * FROM Category WHERE id = ? AND name = ?"
	// 1, "new cate"
	// excute("SELECT * FROM Category WHERE id = ? AND name = ?", 1, "new cate")
	public static ResultSet excute(String sql, Object... params) throws SQLException {
		// B1: Tạo kết nối
		Connection conn = SqlConnection.open();
		// B2: Tạo đối tượng thực thi câu truy
		PreparedStatement ps = conn.prepareStatement(sql);
		// B2.1: Truyền tham số nếu có
		if (params != null) {
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		// B3: Thực thi truy vấn
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public static int update(String sql, Object... params) throws SQLException {
		// B1: Tạo kết nối
		Connection conn = SqlConnection.open();
		// B2: Tạo đối tượng thực thi câu truy
		PreparedStatement ps = conn.prepareStatement(sql);
		// B2.1: Truyền tham số nếu có
		if (params != null) {
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		// B3: Thực thi truy vấn
		return ps.executeUpdate();
	}
}
