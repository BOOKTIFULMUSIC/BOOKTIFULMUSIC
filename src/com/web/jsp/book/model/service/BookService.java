package com.web.jsp.book.model.service;

import static com.web.jsp.common.JDBCTemplate.close;
import static com.web.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.book.model.dao.BookDao;
import com.web.jsp.book.model.vo.Book;

public class BookService {
	private Connection con;
	private BookDao bDao = new BookDao();
	
	public int getListCount() {
		con = getConnection();
		int listCount = bDao.getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<Book> selectList( int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Book> list = bDao.selectList(con,currentPage,limit);
		close(con);
		return list;
	}
}
