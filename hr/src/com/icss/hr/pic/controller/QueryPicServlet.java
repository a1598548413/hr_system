package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * 查询图片列表控制器
 */
@WebServlet("/QueryPicServlet")
public class QueryPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		调用业务对象
		PicService service = new PicService();
		
		try {
			//返回图片集合
			ArrayList<Pic> list =  service.queryPic();
			//转换为json数据格式
			Gson gson = new Gson();
			out.write(gson.toJson(list));			
		} catch (SQLException e) {			
			e.printStackTrace();
		};

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}