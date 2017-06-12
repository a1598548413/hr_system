package com.icss.hr.dept.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.DbUtil;
import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 数据访问对象
 * 
 * @author Administrator
 *
 */
public class DeptDaoImpl implements DeptDao {

	@Override
	public void insert(Dept dept) throws Exception {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into dept values (dept_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());

		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}

	@Override
	public void update(Dept dept) throws Exception {

		Connection conn = DbUtil.getConnection();

		String sql = "update dept set dept_name=?,dept_loc=? where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		pstmt.setInt(3, dept.getDeptId());

		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}

	@Override
	public void delete(int deptId) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}

	@Override
	public Dept queryById(int deptId) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		
		Dept dept = null;
		
		String sql = "select * from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
		
		rs.close();
		pstmt.close();
//		conn.close();

		return dept;
	}

	@Override
	public ArrayList<Dept> query() throws Exception {
		
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		Connection conn = DbUtil.getConnection();		
		
		String sql = "select * from dept order by dept_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
			list.add(dept);
		}
		
		rs.close();
		pstmt.close();
//		conn.close();
		
		return list;
	}

}