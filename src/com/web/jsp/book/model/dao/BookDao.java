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
	public ArrayList<Book> selectList(Connection con, Book b, int currentPage, int limit) {
		ArrayList<Book> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGenreList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getbImage());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setInt(4, b.getbLikeCount());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book bo = new Book();
				
				bo.setbImage(rset.getString("BIMAGES"));
				bo.setBtitle(rset.getString("BTITLE"));
				bo.setAuthor(rset.getString("AUTHOR"));
				bo.setbLikeCount(rset.getInt("BLIKECOUNT"));
				
				list.add(bo);
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
