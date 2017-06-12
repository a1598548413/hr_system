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

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * 获得当前用户密码控制器
 */

@WebServlet("/GetPwdServlet")
public class GetPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		
		EmpService service = new EmpService();
		
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
				
		try {
			Emp emp = service.queryPwdByLoginName(empLoginName);
			out.write(emp.getEmpPwd());
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}