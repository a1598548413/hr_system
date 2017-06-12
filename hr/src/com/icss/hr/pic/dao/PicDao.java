package com.icss.hr.pic.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.DbUtil;
import com.icss.hr.pic.pojo.Pic;

/**
 * 公司图片数据访问层
 * 
 * @author Administrator
 *
 */
public class PicDao {

	/**
	 * 插入数据
	 * 
	 * @throws SQLException
	 */
	public void insert(Pic pic) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into Pic values (pic_seq.nextval,?,?,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getPicInfo());
		pstmt.setLong(3, pic.getPicSize());
		pstmt.setString(4, pic.getPicAuthor());

		InputStream is = pic.getPicData();
		// ojdbc14.jar 必须使用int型
		pstmt.setBinaryStream(5, is, (int) pic.getPicSize());

		pstmt.executeUpdate();
		pstmt.close();
	}

	/**
	 * 查询所有的图片数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Pic> query() throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "select * from pic order by pic_datetime desc";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		ArrayList<Pic> list = new ArrayList<Pic>();

		while (rs.next()) {
			Pic pic = new Pic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), null,
					rs.getDate(7));
			list.add(pic);
		}
		
		rs.close();
		pstmt.close();
		
		return list;
	}
	
	/**
	 * 删除图片数据
	 * @throws SQLException 
	 */
	public void delete(int picId) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from pic where pic_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, picId);
		pstmt.executeUpdate();
		
		pstmt.close();		
	}
	
	/**
	 * 根据id返回图片的数据流
	 * @param picId
	 * @return
	 * @throws SQLException 
	 */
	public Pic queryById(int picId) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from pic where pic_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, picId);
		ResultSet rs = pstmt.executeQuery();
		
		Pic pic = null;
		
		if (rs.next()) {
			pic = new Pic();
			pic.setPicData(rs.getBinaryStream(6));
			pic.setPicName(rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
		
		return pic;		
	}	

}