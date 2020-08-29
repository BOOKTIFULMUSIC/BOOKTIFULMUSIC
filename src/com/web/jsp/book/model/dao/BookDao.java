package com.web.jsp.book.model.dao;

import static com.web.jsp.common.JDBCTemplate.close;

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
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGenreList");
		
		try {
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage-1)*limit +1; // 3-1*10 21
			int endRow = startRow + limit -1; // 30
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Book>();
			
			while(rset.next()) {
				Book bo = new Book();
				bo.setBno(rset.getLong("BNO"));
				bo.setBtitle(rset.getString("BTITLE"));
				bo.setAuthor(rset.getString("PUBLISHER"));
				bo.setWriterDate(rset.getString("WRITERDATE"));
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
			close(pstmt);
		}
		return list;
	}
	public ArrayList<Book> userGenre(Connection con, String userId,int currentPage, int limit) {
		ArrayList<Book> ubList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("userGenreList");
		
		try {
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage-1)*limit +1; // 3-1*10 21
			int endRow = startRow + limit -1; // 30
			pstmt.setString(1, userId);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			
			
			rset = pstmt.executeQuery();
			
			ubList = new ArrayList<Book>();
			
			while(rset.next()) {
				Book bo = new Book();
				bo.setBno(rset.getLong("BNO"));
				bo.setBtitle(rset.getString("BTITLE"));
				bo.setAuthor(rset.getString("PUBLISHER"));
				bo.setWriterDate(rset.getString("WRITERDATE"));
				bo.setBgenre(rset.getString("BGENRE"));
				bo.setPrice(rset.getInt("PRICE"));
				bo.setbLikeCount(rset.getInt("BLIKECOUNT"));
				bo.setbReviewCount(rset.getInt("BREVIEWCOUNT"));
				bo.setbImage(rset.getString("BIMAGE"));
				bo.setbStory(rset.getString("BSTORY"));
			
				ubList.add(bo);
			}
			System.out.println("Dao"+ubList);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ubList;
	}

}
