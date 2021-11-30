package com.web.writeview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostChange")
public class PostChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = (int)request.getAttribute("게시글id");
		
		/*Service service = new Service();
		DTO dto = new DTO();
		dto = service.get(postId);
		
		request.setAttribute("제목", dto.get());
		request.setAttribute("본문", dto.get());
		*/
		String view = ""; //게시글 목록 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
