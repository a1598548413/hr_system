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
 * 删除部门控制器
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//获得输出流
		PrintWriter out = response.getWriter();
		
		//获得部门编号
		String deptId = request.getParameter("deptId");
		
		//调用业务对象
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//删除部门数据
			service.deleteDept(Integer.parseInt(deptId));
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		}
		
		out.println("<script>alert('删除部门成功！');location.href='QueryDeptServlet';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}