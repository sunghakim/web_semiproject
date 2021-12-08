package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.*;

@WebServlet("/PostDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("post_id"));
		
		PostService service = new PostService();
		PostDTO dto = service.searchPost(postId);
		int boardNum = dto.getBoard_num();
		int result = service.deletePost(postId);
		if(result == 0) {
			//성공
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시글 및 관련 댓글이 삭제되었습니다.'); location.href='/BoardSelectController?board_num=' + boardNum + '&page_num=1';</script>");
			out.flush();
		}
		else if(result == 1){
			//게시글 삭제 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시글 삭제에 실패했습니다.'); location.href='/Writeview?post_id=' + postId';</script>");
			out.flush();
		}
		else {
			//게시글에 있는 댓글 삭제 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시글 관련 댓글 삭제에 실패했습니다.'); location.href='/Writeview?post_id=' + postId;</script>");
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
