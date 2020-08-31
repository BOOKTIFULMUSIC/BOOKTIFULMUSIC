package com.web.jsp.book.model.service;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.book.model.dao.BookDao;
import com.web.jsp.book.model.vo.Book;

import static com.web.jsp.common.JDBCTemplate.*;

public class BookService {
	
	private Connection con;
	private BookDao bDao = new BookDao();
	
	public int getListCount() {
		con = getConnection();
		int listCount = bDao.getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<Book> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Book> list = bDao.selectList(con,currentPage,limit);
		close(con);
		return list;
	}

	public ArrayList<Book> userGenre(String userId,int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Book> ubList = bDao.userGenre(con,userId,currentPage,limit);
		close(con);
		return ubList;
	}

	public ArrayList<Book> searchGenre(String[] gArr,int currentPage, int limit) {
		con = getConnection();
		ArrayList<Book> sList = bDao.searchGenre(con,gArr,currentPage,limit);
		close(con);
		return sList;
	}

	
}
