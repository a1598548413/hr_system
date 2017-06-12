package com.icss.hr.dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

/**
 * ��ѯ�������ݿ�����
 */
@WebServlet("/QueryDeptServlet")
public class QueryDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����ҵ�����
		DeptServiceImpl service = new DeptServiceImpl();

		try {
			// ������ݼ���
			ArrayList<Dept> list = service.queryDept();
			// ��request��Χ����������
			request.setAttribute("list", list);
			//����ת����JSP��ͼ
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//ת��������ҳ
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}