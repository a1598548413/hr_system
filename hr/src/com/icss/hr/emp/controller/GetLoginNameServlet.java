package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户名数据接口
 */
@WebServlet("/GetLoginNameServlet")
public class GetLoginNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		out.print(empLoginName);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}