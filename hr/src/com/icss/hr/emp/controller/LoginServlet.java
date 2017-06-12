package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;

/**
 * 登录控制器
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// 获得请求参数
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");

		// 调用业务对象
		EmpService service = new EmpService();
		
		try {
			//得到验证结果
			int result = service.checkLogin(empLoginName, empPwd);			
			out.print(result);
			
			//如果登录验证通过，在session中存储登录标识
			if (result == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("empLoginName", empLoginName);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}