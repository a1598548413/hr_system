package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * 删除职务控制器
 */
@WebServlet("/DelJobServlet")
public class DelJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得输出流
		PrintWriter out = response.getWriter();

		// 获得请求参数
		String jobId = request.getParameter("jobId");

		// 调用业务对象
		JobService service = new JobService();

		try {
			// 删除职务
			service.deleteJob(Integer.parseInt(jobId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}