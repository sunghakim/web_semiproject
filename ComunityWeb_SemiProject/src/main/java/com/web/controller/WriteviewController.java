package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.post.model.*;
import com.web.writeview.model.*;

@WebServlet("/Writeview")
public class WriteviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("post_id"));
		PostService p_service = new PostService();
		PostDTO dto = p_service.searchPost(postId);
		request.setAttribute("post_info", dto);
		
		//댓글 리스트 불러오기
		CommentService service = new CommentService();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = service.getCommentList(postId);
		
		request.setAttribute("cList", commentList);
		
		String view = "/WEB-INF/jsp/writeview.jsp"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("post_id"));
		//
		//
		//
		// 쿠키나 세션으로 가져오기
		String writerId = "sungha";
		
		String comments = request.getParameter("context");
		String date = request.getParameter("date");
		String commentId = request.getParameter("comment_id");
		
		CommentService service = new CommentService();
		if(commentId.equals("null")) {
			CommentDTO dto = new CommentDTO();
			dto.setWriteId(postId);
			dto.setWriter(writerId);
			dto.setComment(comments);
			dto.setCommentDate(date);
			
			if(service.isValid(dto)) {
				if(service.addComment(dto)) {
					//정상적으로 db에 저장됨.
				}
				else {
					//db에 저장 안됨 (오류 발생 알람)
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('데이터베이스 저장 시 문제가 발생했습니다.'); location.href='/Writeview';</script>");
					out.flush();
				}
			}
			else {
				//댓글이 없습니다. (알람)
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('댓글 내용이 없습니다.'); location.href='/Writeview';</script>");
				out.flush();
			}
		}
		else {
			CommentDTO dto = new CommentDTO(Integer.parseInt(commentId), postId, writerId, comments, date);
			if(service.isValid(dto)) {
				if(service.changeComment(dto)) {
					//정상적으로 db에 저장됨.
				}
				else {
					//db에 저장 안됨 (오류 발생 알람)
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('데이터베이스 저장 시 문제가 발생했습니다.'); location.href='/Writeview';</script>");
					out.flush();
				}
			}
			else {
				//댓글이 없습니다. (알람)
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('댓글 내용이 없습니다.'); location.href='/Writeview';</script>");
				out.flush();
			}
		}
		
		PostService p_service = new PostService();
		PostDTO dto = p_service.searchPost(postId);
		request.setAttribute("post_info", dto);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = service.getCommentList(postId); //개인 TEST 용
		
		request.setAttribute("cList", commentList);
		
		String view = "/WEB-INF/jsp/writeview.jsp"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}