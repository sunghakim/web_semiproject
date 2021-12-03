package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.post.model.*;

@WebServlet("/PostChange")
public class PostChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("post_id"));
		
		request.setAttribute("post_id", postId);
		
		PostService service = new PostService();
		PostDTO dto = new PostDTO();
		dto = service.searchPost(postId);
		
		request.setAttribute("post_content", dto.getPost_content());
		request.setAttribute("post_title", dto.getPost_title());
		request.setAttribute("board", dto.getBoard_num());
		
		String view = "WEB-INF/jsp/postwrite.jsp"; //게시글 수정 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
