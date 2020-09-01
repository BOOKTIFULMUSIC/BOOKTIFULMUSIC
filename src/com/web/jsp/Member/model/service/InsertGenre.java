package com.web.jsp.Member.model.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class InsertGenre
 */
@WebServlet("/popInsert.mo")
public class InsertGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertGenre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		String bgenre = request.getParameter("bgenre");
		String mgenre = request.getParameter("mgenre");
		
		String[] bgen = bgenre.split(","); 
		String[] mgen = mgenre.split(",");
		
		try {
			ms.insertBgenre(id,bgen);
			ms.insertBgenre(id,mgen);
			System.out.println("서블릿까지 돌아오기 성공");
			response.sendRedirect("pop_genre_select.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
