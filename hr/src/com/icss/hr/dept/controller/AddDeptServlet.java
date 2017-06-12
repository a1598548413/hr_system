package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

/**
 * ���Ӳ��ſ�����
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		�����
		PrintWriter out = response.getWriter();
		
//		��ñ�����
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
//		��װpojo����
		Dept dept = new Dept(deptName,deptLoc);
		
//		����ҵ����
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.addDept(dept);
		} catch (Exception e) {			
			e.printStackTrace();
			//ת��������ҳ
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('���Ӳ��ųɹ���');location.href='QueryDeptServlet';</script>");	
		//response.sendRedirect("QueryDeptServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);;
	}

}
