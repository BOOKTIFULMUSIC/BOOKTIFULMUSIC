package com.web.jsp.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.jsp.book.model.service.BookService;
import com.web.jsp.book.model.vo.Book;

/**
 * Servlet implementation class BuserGenreServlet
 */
@WebServlet("/bUserGenre.bo")
public class BuserGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuserGenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		BookService bs = new BookService();
		ArrayList<Book> ubList = new BookService().userGenre(userId); 
		
		
		String page = "";
		if(ubList != null) {
			page = "views/book/bookGenre.jsp";
			request.setAttribute("ubList", ubList);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원님이 선택한 장르 리스트 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
