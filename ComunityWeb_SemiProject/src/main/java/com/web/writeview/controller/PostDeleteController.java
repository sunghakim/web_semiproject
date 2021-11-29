package com.web.writeview.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.writeview.model.CommentService;

@WebServlet("/PostDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = (int)request.getAttribute("게시글 번호");
		//Service service = new Service();
		//if(service.delete(postId)) {
			//성공
		//}
		//else {
			//삭제 실패
		//}
		
		response.sendRedirect("/Writeboard");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
