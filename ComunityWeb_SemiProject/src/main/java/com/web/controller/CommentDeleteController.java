package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글이 삭제되었습니다.'); location.href='/PostController';</script>");
			out.flush();
		}
		else {
			//삭제 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글 삭제에 실패했습니다.'); location.href='/PostController';</script>");
			out.flush();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
