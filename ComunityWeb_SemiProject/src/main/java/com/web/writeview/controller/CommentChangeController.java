package com.web.writeview.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.writeview.model.*;

@WebServlet("/CommentChange")
public class CommentChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = (int)request.getAttribute("댓글id");
		
		CommentService service = new CommentService();
		CommentDTO dto = new CommentDTO();
		dto = service.getComment(commentId);
		if(service.deleteComment(commentId)) {
			//삭제 성공
		}
		else {
			//삭제 실패
		}
		
		request.setAttribute("댓글내용", dto.getComment());
		
		String view = ""; //게시글 상세 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
