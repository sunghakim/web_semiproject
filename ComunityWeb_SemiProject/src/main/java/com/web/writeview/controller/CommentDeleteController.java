package com.web.writeview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글이 삭제되었습니다.'); location.href='/Writeview';</script>");
			out.flush();
		}
		else {
			//삭제 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글 삭제에 실패했습니다.'); location.href='/Writeview';</script>");
			out.flush();
		}
		
		String view = "/WEB-INF/jsp/writeview/views"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
