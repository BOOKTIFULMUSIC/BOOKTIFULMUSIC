package com.web.jsp.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.notice.model.vo.Notice;
import static com.web.jsp.common.JDBCTemplate.*;

public class NoticeDao {
	
	private Properties prop = null;
	
	public NoticeDao(){
		prop = new Properties();
		String filePath = NoticeDao.class
						 .getResource("/config/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<Notice> selectList(Connection con, String ntype) {
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ntype);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Notice n = new Notice();
				n.setNno(rset.getString("nno"));
				n.setType(rset.getString("type"));
				n.setNtitle(rset.getString("ntitle"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNdate(rset.getDate("ndate"));
				
				list.add(n);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

}
