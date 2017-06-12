package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * ��Ӧ��Ӧ��ͼƬ������
 */
@WebServlet("/DownloadPicServlet")
public class DownloadPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//������Ӧ��MIME����Ϊ�����������
		response.setContentType("image/*");

		// ��Ӧ�ֽ������
		OutputStream out = response.getOutputStream();

		// ���ͼƬid
		String picId = request.getParameter("picId");

		// ����ҵ�����
		PicService service = new PicService();		
		
		try {
			//����ͼƬ����
			Pic pic = service.queryPicById(Integer.parseInt(picId));
			
			//����ͼƬ�ļ���
			String picName = pic.getPicName();
			
			//������Ӧ��ͷ��������Ը�����ʽ��������
			response.setHeader("Content-disposition","attachment;filename=" + picName); 
			
			InputStream is = pic.getPicData();
			
			byte[] b = new byte[1024 * 16];
			
			int len = is.read(b);
			
			while (len != -1) {
				out.write(b, 0, len);
				len = is.read(b);
			}
			
			out.flush();
			
			is.close();
			out.close();
			
		} catch (NumberFormatException | SQLException e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}