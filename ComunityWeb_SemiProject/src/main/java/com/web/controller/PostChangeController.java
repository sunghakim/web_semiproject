package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.*;

@WebServlet("/PostChange")
public class PostChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("post_id"));
		
		request.setAttribute("post_id", postId);
		System.out.println("post_id set");
		PostService service = new PostService();
		PostDTO dto = new PostDTO();
		dto = service.searchPost(postId);
		System.out.println("searchpost");
		request.setAttribute("post_content", dto.getPost_content());
		request.setAttribute("post_title", dto.getPost_title());
		request.setAttribute("board", dto.getBoard_num());
		System.out.println("sets3");
		String view = "WEB-INF/jsp/board/boardWrite.jsp"; //게시글 수정 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		System.out.println("view 이동");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
