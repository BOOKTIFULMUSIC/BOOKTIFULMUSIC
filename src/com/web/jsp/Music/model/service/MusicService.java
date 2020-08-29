package com.web.jsp.Music.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.Music.model.dao.MusicDao;
import com.web.jsp.Music.model.vo.Music;


import static com.web.jsp.common.JDBCTemplate.*;

public class MusicService {
	
	private MusicDao mDao = new MusicDao();
	private Connection con;

	public ArrayList<Music> musicChart() {
		
		con = getConnection();
		
		ArrayList<Music> list = mDao.musicChart(con);
		close(con);
		return list;
	}

}
