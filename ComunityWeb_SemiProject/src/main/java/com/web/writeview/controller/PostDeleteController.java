package com.web.writeview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = (int)request.getAttribute("게시글 번호");
		/*Service service = new Service();
		if(service.delete(postId)) {
			//성공
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시글이 삭제되었습니다.'); location.href='/Writeview';</script>");
			out.flush();
		}
		else {
			//삭제 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시글 삭제 시 문제가 발생했습니다.'); location.href='/Writeview';</script>");
			out.flush();
		}
		*/
		String view = "/WEB-INF/jsp/writeview/views"; //게시글 목록 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
