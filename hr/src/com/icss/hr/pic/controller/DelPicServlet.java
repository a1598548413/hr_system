package com.icss.hr.pic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.service.PicService;

/**
 * 删除指定照片
 */
@WebServlet("/DelPicServlet")
public class DelPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得图片id
		String picId = request.getParameter("picId");
		
		//调用业务对象
		PicService service = new PicService();
		
		try {
			//删除图片
			service.deletePic(Integer.parseInt(picId));
			
		} catch (NumberFormatException | SQLException e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}