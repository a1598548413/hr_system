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
 * 查询部门数据控制器
 */
@WebServlet("/QueryDeptServlet")
public class QueryDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 调用业务对象
		DeptServiceImpl service = new DeptServiceImpl();

		try {
			// 获得数据集合
			ArrayList<Dept> list = service.queryDept();
			// 在request范围中设置数据
			request.setAttribute("list", list);
			//请求转发到JSP视图
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//转发到错误页
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}