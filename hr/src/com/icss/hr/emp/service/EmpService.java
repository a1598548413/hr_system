package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * Ա��ҵ�����
 * @author Administrator
 *
 */
public class EmpService {
	
	private EmpDao empDao = new EmpDao();	
		
	/**
	 * �û���������֤
	 * @param empLoginName
	 * @param empPwd
	 * @return 1�û���������  2�������  3��֤�ɹ�
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
	 * ����¼���Ƿ����
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
	 * ������Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException {
		
		empDao.insert(emp);
		
	}	
	
	/**
	 * ����Ա������
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		
		return empDao.getCount();
	}
	
	/**
	 * ��ҳ��ѯԱ������ 
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Emp> queryEmpByPage(Pager pager) throws SQLException {
		
		return empDao.queryByPage(pager);		
	}
	
	/**
	 * ����id��ѯԱ������
	 * @param empId
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryEmpById(int empId) throws SQLException {
		return empDao.queryById(empId);
	}
	
	/**
	 * �޸�Ա������
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException {
		empDao.update(emp);		
	}
	
	/**
	 * ����idɾ��Ա��
	 * @param empId
	 * @throws SQLException 
	 */
	public void deleteEmp(int empId) throws SQLException {
		empDao.delete(empId);
	}
	
	/**
	 * �޸ĵ�ǰԱ��ͷ��
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		
		empDao.updateEmpPic(empLoginName, empPic);
		
	}
	
	/**
	 * ��ѯͷ��base64����
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	public String queryEmpPic(String empLoginName) throws SQLException {
		return empDao.queryEmpPic(empLoginName);
	}
	
	/**
	 * ��ѯ�û�����
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryPwdByLoginName(String empLoginName) throws SQLException {
		
		return empDao.queryByLoginName(empLoginName);
		
	}
	
	/**
	 * �޸�����
	 * @throws SQLException 
	 */
	public void updatePwd(Emp emp) throws SQLException {
		empDao.updatePwd(emp);
	}
	
}