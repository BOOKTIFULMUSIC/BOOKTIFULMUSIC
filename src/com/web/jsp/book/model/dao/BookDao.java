package com.web.jsp.book.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.book.model.vo.Book;
import static com.web.jsp.common.JDBCTemplate.*;

public class BookDao {
private Properties prop;
	
	public BookDao() {
		prop = new Properties();
		
		String filePath = BookDao.class.getResource("/config/book-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	public ArrayList<Book> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Book> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGenreList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Book>();
			
			while(rset.next()) {
				Book bo = new Book();
				bo.setBno(rset.getInt("BNO"));
				bo.setBtitle(rset.getString("BTITLE"));
				bo.setAuthor(rset.getString("PUBLISHER"));
				bo.setWriterDate(rset.getDate("WRITERDATE"));
				bo.setBgenre(rset.getString("BGENRE"));
				bo.setPrice(rset.getInt("PRICE"));
				bo.setbLikeCount(rset.getInt("BLIKECOUNT"));
				bo.setbReviewCount(rset.getInt("BREVIEWCOUNT"));
				bo.setbImage(rset.getString("BIMAGE"));
				bo.setbStory(rset.getString("BSTORY"));
			
				list.add(bo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
}
