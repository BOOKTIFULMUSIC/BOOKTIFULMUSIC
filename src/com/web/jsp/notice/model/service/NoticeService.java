package com.web.jsp.notice.model.service;

import static com.web.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.notice.model.dao.NoticeDao;
import com.web.jsp.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao nDao = new NoticeDao();

	public ArrayList<Notice> selectList(String ntype) {
		
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.selectList(con, ntype);
		
		close(con);
		
		
		return list;
	}

}
