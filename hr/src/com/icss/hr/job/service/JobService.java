package com.icss.hr.job.service;

import java.util.ArrayList;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 部门业务对象
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	public void addJob(Job job) throws Exception {
		dao.insert(job);
	}
	
	public void updateJob(Job job) throws Exception {
		dao.update(job);
	}
	
	public void deleteJob(int jobId) throws Exception {
		dao.delete(jobId);
	}
	
	public Job queryJobById(int jobId) throws Exception {
		
		return dao.queryById(jobId);
	}
	
	public ArrayList<Job> queryJob() throws Exception {
		
		return dao.query();
	}

}