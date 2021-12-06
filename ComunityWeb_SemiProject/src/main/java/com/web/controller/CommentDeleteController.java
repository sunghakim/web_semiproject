package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.CommentService;

@WebServlet("/CommentDelete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("comment_id"));
		
		CommentService service = new CommentService();
		int postId = service.getComment(commentId).getWriteId();
		System.out.println(postId);
		if(service.deleteComment(commentId)) {
			//성공
			String view = "/Writeview?post_id=" + postId;
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		else {
			//삭제 실패 -> 삭제 실패했다고 알림창 프론트에 해달라고 요청
			String view = "/Writeview?post_id=" + postId;
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
