package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * ≤‚ ‘ ˝æ›∑÷Œˆ
 * @author Administrator
 *
 */
public class TestAnADao {
	
	private AnaDao dao = new AnaDao();
	
	@Test
	public void testQueryEmpCount() throws SQLException {
		
		ArrayList<Map<String,Object>> list = dao.queryEmpCount();
		
		for (Map map : list) {
			System.out.println(map);
		}
		
	}

}