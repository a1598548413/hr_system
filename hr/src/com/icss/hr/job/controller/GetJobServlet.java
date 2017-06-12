package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * ���ְ�����ݿ�����
 */
@WebServlet("/GetJobServlet")
public class GetJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		��������
		PrintWriter out = response.getWriter();
		
//		���ְ��id
		String jobId = request.getParameter("jobId");
		
//		����ҵ�����
		JobService service = new JobService();
		
		try {
			//���ְ������
			Job job = service.queryJobById(Integer.parseInt(jobId));
//			ת��Ϊjson����
			Gson gson = new Gson();
			out.write( gson.toJson(job) );
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}