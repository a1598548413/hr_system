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
 * ɾ��ָ����Ƭ
 */
@WebServlet("/DelPicServlet")
public class DelPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ͼƬid
		String picId = request.getParameter("picId");
		
		//����ҵ�����
		PicService service = new PicService();
		
		try {
			//ɾ��ͼƬ
			service.deletePic(Integer.parseInt(picId));
			
		} catch (NumberFormatException | SQLException e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}