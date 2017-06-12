package com.icss.hr.dept.service;

import java.util.ArrayList;

import com.icss.hr.dept.pojo.Dept;

/**
 * 
 * 部门业务接口
 *
 */
public interface DeptService {

	void addDept(Dept dept) throws Exception;
	
	void updateDept(Dept dept)  throws Exception;
	
	void deleteDept(int deptId) throws Exception;
	
	Dept queryDeptById(int deptId) throws Exception;
	
	ArrayList<Dept> queryDept() throws Exception;
	
}