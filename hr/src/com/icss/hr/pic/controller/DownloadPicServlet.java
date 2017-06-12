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
 * 响应对应的图片数据流
 */
@WebServlet("/DownloadPicServlet")
public class DownloadPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//设置响应的MIME类型为二进制输出流
		response.setContentType("image/*");

		// 响应字节输出流
		OutputStream out = response.getOutputStream();

		// 获得图片id
		String picId = request.getParameter("picId");

		// 调用业务对象
		PicService service = new PicService();		
		
		try {
			//返回图片数据
			Pic pic = service.queryPicById(Integer.parseInt(picId));
			
			//返回图片文件名
			String picName = pic.getPicName();
			
			//设置响应报头，浏览器以附件形式接收数据
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