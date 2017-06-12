package com.icss.hr.dept.service.impl;

import java.util.ArrayList;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * 部门业务实现类
 * @author Administrator
 *
 */
public class DeptServiceImpl implements DeptService {
	
	private DeptDaoImpl dao = new DeptDaoImpl();

	@Override
	public void addDept(Dept dept) throws Exception {
		dao.insert(dept);		
	}

	@Override
	public void updateDept(Dept dept) throws Exception {
		dao.update(dept);		
	}

	@Override
	public void deleteDept(int deptId) throws Exception {
		dao.delete(deptId);		
	}

	@Override
	public Dept queryDeptById(int deptId) throws Exception {
		
		return dao.queryById(deptId);
	}

	@Override
	public ArrayList<Dept> queryDept() throws Exception {
		
		return dao.query();
	}

}