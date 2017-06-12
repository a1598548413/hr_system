package com.icss.hr.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.DbUtil;
import com.icss.hr.job.pojo.Job;

public class JobDao {

	public void insert(Job job) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "insert into job values(job_seq.Nextval,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setInt(2, job.getJobMinSal());
		pstmt.setInt(3, job.getJobMaxSal());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public void delete(int jobId) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "delete from job where job_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public void update(Job job) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "update job set job_name = ?, job_min_sal = ?, job_max_sal = ? where job_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setInt(2, job.getJobMinSal());
		pstmt.setInt(3, job.getJobMaxSal());
		pstmt.setInt(4, job.getJobId());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public Job queryById(int jobId) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DbUtil.getConnection();
		String sql = "select * from job where job_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return new Job(rs.getInt("job_id"), rs.getString("job_name"), rs.getInt("job_min_sal"),
					rs.getInt("job_max_sal"));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return null;
	}

	public ArrayList<Job> query() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DbUtil.getConnection();
		String sql = "select * from job";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Job> list = new ArrayList<Job>();
		while (rs.next()) {
			list.add(new Job(rs.getInt("job_id"), rs.getString("job_name"), rs.getInt("job_min_sal"),
					rs.getInt("job_max_sal")));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

}
