package com.icss.test;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

public class TestJobDao {
	JobDao jdao = new JobDao();

	@Test
	public void testInsert() {
		Job job = new Job("ндт╠", 100000, 300000);
		try {
			jdao.insert(job);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		try {
			jdao.delete(1);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		Job job = new Job(2, "CTO", 20100, 30100);
		try {
			jdao.update(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryById() {
		try {
			Job job = jdao.queryById(2);
			System.out.println(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryJobList() {
		try {
			ArrayList<Job> jobs = jdao.query();
			System.out.println(jobs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
