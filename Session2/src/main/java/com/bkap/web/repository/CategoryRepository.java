package com.bkap.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bkap.web.entity.Category;
import com.bkap.web.util.SqlConnection;

public class CategoryRepository implements IGenericRepository<Category, Integer> {

	@Override
	public List<Category> getAll() {
		List<Category> data = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Categories";
			// B3: Thực thi truy vấn
			ResultSet rs = SqlConnection.excute(sql);
			// B4: Đọc kết kết quả
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("catId"));
				c.setCatname(rs.getString("catname"));
				c.setCounts(rs.getInt("counts"));
				data.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Category add(Category entity) {
		try {
			String sql = "INSERT INTO Categories VALUES(?,?,?)";
			// B3: Thực thi truy vấn
			SqlConnection.update(sql, entity.getId(), entity.getCatname(), entity.getCounts());
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category edit(Category entity) {
		try {
			String sql = "UPDATE Categories SET catname = ?, counts = ? WHERE catId = ?";
			Object[] params = new Object[] { entity.getCatname(), entity.getCounts(), entity.getId() };
			// B3: Thực thi truy vấn
			SqlConnection.update(sql, params);
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			String sql = "DELETE Categories WHERE catId = ?";
			// B3: Thực thi truy vấn
			int result = SqlConnection.update(sql, id);
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category findId(Integer id) {
		try {
			String sql = "SELECT * FROM Categories WHERE catId = ?";
			// B3: Thực thi truy vấn
			ResultSet rs = SqlConnection.excute(sql, id);
			// B4: Đọc kết kết quả
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("catId"));
				c.setCatname(rs.getString("catname"));
				c.setCounts(rs.getInt("counts"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
