package com.icss.hr.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.icss.hr.common.DbUtil;

/**
 * 数据分析
 * @author Administrator
 *
 */
public class AnaDao {
	
	/**
	 * 统计每个部门的员工人数
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Map<String,Object>> queryEmpCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();		
		sb.append("SELECT d.dept_name,COUNT(e.emp_id) ");
		sb.append("FROM emp e ");
		sb.append("RIGHT OUTER JOIN dept d ON e.emp_dept_id = d.dept_id ");
		sb.append("GROUP BY d.dept_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();	
		
		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("deptName", rs.getString(1));
			map.put("empCount",rs.getInt(2));
			
			list.add(map);
		}
		
		rs.close();
		pstmt.close();
		
		return list;		
	}

}
