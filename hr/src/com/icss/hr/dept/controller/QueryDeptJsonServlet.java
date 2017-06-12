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
 * 部门数据访问接口
 */
@WebServlet("/QueryDeptJsonServlet")
public class QueryDeptJsonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		调用业务对象
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//返回部门数据集合
			ArrayList<Dept> list = service.queryDept();
//			转换为json数据格式
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