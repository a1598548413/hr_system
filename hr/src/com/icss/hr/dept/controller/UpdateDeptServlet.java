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
 * 修改部门控制器
 */
@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得表单数据
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
//		封装pojo对象
		Dept dept = new Dept(Integer.parseInt(deptId),deptName,deptLoc);
		
//		调用业务功能
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.updateDept(dept);
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		}
		
		out.println("<script>alert('修改部门成功！');location.href='QueryDeptServlet';</script>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}