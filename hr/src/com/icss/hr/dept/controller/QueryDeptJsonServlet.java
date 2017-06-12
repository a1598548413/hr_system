package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

/**
 * �������ݷ��ʽӿ�
 */
@WebServlet("/QueryDeptJsonServlet")
public class QueryDeptJsonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		����ҵ�����
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//���ز������ݼ���
			ArrayList<Dept> list = service.queryDept();
//			ת��Ϊjson���ݸ�ʽ
			Gson gson = new Gson();
			out.write( gson.toJson(list) );
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}