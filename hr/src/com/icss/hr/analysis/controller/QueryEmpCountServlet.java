package com.icss.hr.analysis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.analysis.service.AnAService;

/**
 * 统计员工人数数据访问接口
 */
@WebServlet("/QueryEmpCountServlet")
public class QueryEmpCountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//业务对象
		AnAService service = new AnAService();
		
		try {
			//获得统计数据
			ArrayList<Map<String,Object>> list = service.queryEmpCount();
			//转换为JSON格式
			Gson gson = new Gson();
			out.write( gson.toJson(list) );
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}