package com.icss.hr.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;

/**
 * 上传用户头像
 */
@WebServlet("/UpdateEmpPicServlet")
public class UpdateEmpPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获得用户头像数据
		String imgBase64 = request.getParameter("imgBase64");
		
		//调用业务对象
		EmpService service = new EmpService();
		
		//从session获得用户登录名称
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		try {
			//更新头像数据
			service.updateEmpPic(empLoginName, imgBase64);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}