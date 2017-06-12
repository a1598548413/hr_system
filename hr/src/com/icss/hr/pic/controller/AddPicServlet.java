package com.icss.hr.pic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * 上传照片
 */
@WebServlet("/AddPicServlet")
public class AddPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得Servlet上下文对象
		ServletContext context = this.getServletContext();

		// 磁盘文件列表工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置内存区块大小4KB
		factory.setSizeThreshold(4 * 1024);

		// 设置暂存容器临时目录，当上传文件大于设置的内存块大小时，用暂存容器做中转（非常重要）
		File temp = new File(context.getRealPath("/temp"));
		
		if (!temp.exists())
			temp.mkdirs();
		
		factory.setRepository(temp);

		// Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 获得登录用户名
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");

		try {
			// 设置最大上传文件大小为1000M，超出大小会发生异常
			upload.setSizeMax(1024 * 1024 * 1000);

			// 获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest(request);

			// 获得图片数据
			FileItem picData = list.get(0);
			// 获得文件描述
			String picInfo = list.get(1).getString();
			picInfo = new String(picInfo.getBytes("iso-8859-1"), "utf-8");

			// 封装为pojo对象
			Pic pic = new Pic(picData.getName(), picInfo, picData.getSize(), empLoginName, picData.getInputStream(),
					null);
			
			//调用业务对象
			PicService service = new PicService();
			
			//插入图片数据
			service.addPic(pic);
			
			//删除临时文件

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}