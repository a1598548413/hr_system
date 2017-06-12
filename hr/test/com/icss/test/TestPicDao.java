package com.icss.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * Õºø‚DAO≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestPicDao {
	
	private PicDao dao = new PicDao();
	
	@Test
	public void testInsert() throws FileNotFoundException, SQLException {
		
		File file = new File("e:\\pic/07.jpg");
		
		FileInputStream fis = new FileInputStream(file);
		
		Pic pic = new Pic("07.jpg","¥Û“Ø£¨Ω¯¿¥ÕÊ—Ω",file.length(),"jack",fis,null);
		
		dao.insert(pic);
		
	}
	
	@Test
	public void testQuery() throws SQLException {
		
		ArrayList<Pic> list = dao.query();
		
		for (Pic pic : list) {
			System.out.println(pic);
		}
		
	}
	
	

}
