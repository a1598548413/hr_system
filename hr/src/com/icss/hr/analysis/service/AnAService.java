package com.icss.hr.analysis.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * ���ݷ���ҵ���߼�
 * @author Administrator
 *
 */
public class AnAService {
	
	private AnaDao dao = new AnaDao();
	
	/**
	 * ͳ��ÿ�����ŵ�����
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Map<String,Object>> queryEmpCount() throws SQLException {
		return dao.queryEmpCount();
	}

}