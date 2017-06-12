package com.icss.hr.analysis.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * 数据分析业务逻辑
 * @author Administrator
 *
 */
public class AnAService {
	
	private AnaDao dao = new AnaDao();
	
	/**
	 * 统计每个部门的人数
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Map<String,Object>> queryEmpCount() throws SQLException {
		return dao.queryEmpCount();
	}

}