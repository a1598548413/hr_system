package com.icss.hr.pic.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * Í¼¿âÒµÎñ²ã
 * @author Administrator
 *
 */
public class PicService {
	
	private PicDao dao = new PicDao();
	
	public void addPic(Pic pic) throws SQLException {
		dao.insert(pic);
	}
	
	public void deletePic(int picId) throws SQLException {
		dao.delete(picId);
	}
	
	public Pic queryPicById(int picId) throws SQLException {
		return dao.queryById(picId);
	}
	
	public ArrayList<Pic> queryPic() throws SQLException {
		return dao.query();
	}

}