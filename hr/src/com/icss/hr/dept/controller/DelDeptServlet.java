package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;

/**
 * ɾ�����ſ�����
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//��������
		PrintWriter out = response.getWriter();
		
		//��ò��ű��
		String deptId = request.getParameter("deptId");
		
		//����ҵ�����
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//ɾ����������
			service.deleteDept(Integer.parseInt(deptId));
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		}
		
		out.println("<script>alert('ɾ�����ųɹ���');location.href='QueryDeptServlet';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}