package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	BoardManagement manage;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		manage = new BoardManagement();
		
		req.setAttribute("boardList", manage.boardList());
		req.getRequestDispatcher("board.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String create = req.getParameter("create");
		String[] update = req.getParameterValues("update");
		Integer delete = Integer.parseInt(req.getParameter("delete"));
		
		if(create != null) {
			System.out.println("추가한 카테고리 : "+ create);
			manage.insertCategory(create);
		}
		
		if(update != null) {
			int categoryNum = Integer.parseInt(update[0]);
			String categoryName = update[1];
			System.out.println("수정 전 카테고리 : ...");
			System.out.println("수정한 카테고리 : " + categoryNum + ", " + categoryName);
			manage.updateCategory(categoryNum, categoryName);
		}
		
		if(delete != null) {
			System.out.println("지운 카테고리 : " + delete);
			manage.deleteCategory(delete);
		}
		resp.sendRedirect("BoardManagement");

	}
}
