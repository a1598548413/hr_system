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
 * 增加部门控制器
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		输出流
		PrintWriter out = response.getWriter();
		
//		获得表单数据
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
//		封装pojo对象
		Dept dept = new Dept(deptName,deptLoc);
		
//		调用业务功能
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.addDept(dept);
		} catch (Exception e) {			
			e.printStackTrace();
			//转发到错误页
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('增加部门成功！');location.href='QueryDeptServlet';</script>");	
		//response.sendRedirect("QueryDeptServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);;
	}

}
