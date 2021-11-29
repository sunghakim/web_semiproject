package com.web.writeview.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.writeview.model.CommentService;

@WebServlet("/CommentDelete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int commentId = (int)request.getAttribute("댓글 번호");
		CommentService service = new CommentService();
		if(service.deleteComment(commentId)) {
			//성공
		}
		else {
			//삭제 실패
		}
		
		response.sendRedirect("/Writeview");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
