package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * 员工业务对象
 * @author Administrator
 *
 */
public class EmpService {
	
	private EmpDao empDao = new EmpDao();	
		
	/**
	 * 用户名密码验证
	 * @param empLoginName
	 * @param empPwd
	 * @return 1用户名不存在  2密码错误  3验证成功
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		
		Emp emp = empDao.queryByLoginName(empLoginName);
		
		if (emp == null)
			return 1;
		else if (!empPwd.equals(emp.getEmpPwd()))
			return 2;
		
		return 3;		
	}
	
	
	/**
	 * 检查登录名是否存在
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkLoginName(String empLoginName) throws SQLException {
		
		Emp emp = empDao.queryByLoginName(empLoginName);
		
		if (emp == null)
			return false;
		
		return true;		
	}
	
	/**
	 * 增加新员工
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException {
		
		empDao.insert(emp);
		
	}	
	
	/**
	 * 返回员工总数
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		
		return empDao.getCount();
	}
	
	/**
	 * 分页查询员工数据 
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Emp> queryEmpByPage(Pager pager) throws SQLException {
		
		return empDao.queryByPage(pager);		
	}
	
	/**
	 * 根据id查询员工数据
	 * @param empId
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryEmpById(int empId) throws SQLException {
		return empDao.queryById(empId);
	}
	
	/**
	 * 修改员工数据
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException {
		empDao.update(emp);		
	}
	
	/**
	 * 根据id删除员工
	 * @param empId
	 * @throws SQLException 
	 */
	public void deleteEmp(int empId) throws SQLException {
		empDao.delete(empId);
	}
	
	/**
	 * 修改当前员工头像
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		
		empDao.updateEmpPic(empLoginName, empPic);
		
	}
	
	/**
	 * 查询头像base64数据
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	public String queryEmpPic(String empLoginName) throws SQLException {
		return empDao.queryEmpPic(empLoginName);
	}
	
	/**
	 * 查询用户密码
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryPwdByLoginName(String empLoginName) throws SQLException {
		
		return empDao.queryByLoginName(empLoginName);
		
	}
	
	/**
	 * 修改密码
	 * @throws SQLException 
	 */
	public void updatePwd(Emp emp) throws SQLException {
		empDao.updatePwd(emp);
	}
	
}