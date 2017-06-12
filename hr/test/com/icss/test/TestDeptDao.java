package com.icss.test;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.pojo.Dept;

public class TestDeptDao {
	
	private DeptDaoImpl dao = new DeptDaoImpl();
	
	@Test
	public void testInsert() throws Exception {
		
		Dept dept = new Dept("销售部","北京");
		dao.insert(dept);
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		Dept dept = new Dept(10,"第二开发部","大连");
		dao.update(dept);
		
	}
	
	@Test
	public void testDelete() throws Exception {
				
		dao.delete(10);
		
	}
	
	@Test
	public void testQueryById() throws Exception {
				
		Dept dept = dao.queryById(20);
		System.out.println(dept);
		
	}
	
	@Test
	public void testQuery() throws Exception {
				
		ArrayList<Dept> list = dao.query();
		System.out.println(list);
		
	}

}
