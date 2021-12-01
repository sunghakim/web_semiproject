package com.web.writeview.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.writeview.model.*;

@WebServlet("/Writeview")
public class WriteviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 내용 불러오기
		//게시글 controller, service, dao, dto 필요.
		//List<> postList = new ArrayList<>();
		//postList = ;
		
		//댓글 리스트 불러오기
		CommentService service = new CommentService();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		//commentList = service.getCommentList((int)request.getAttribute("board_num"));
		commentList = service.getCommentList(1); //개인 TEST 용
		
		request.setAttribute("cList", commentList);
		
		String view = "/WEB-INF/jsp/writeview.jsp"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int postId = (int)request.getAttribute("게시글번호");
		//String writerId = (String)request.getAttribute("작성자id");
		int postId = 1;
		String writerId = "sungha";
		String comments = request.getParameter("context");
		String date = request.getParameter("date");
		String commentId = (String)request.getAttribute("댓글id");
		
		CommentService service = new CommentService();
		System.out.println((String)request.getAttribute("댓글id") + "|");
		if(commentId == null) {
			CommentDTO dto = new CommentDTO();
			dto.setWriteId(postId);
			dto.setWriter(writerId);
			dto.setComment(comments);
			dto.setCommentDate(date);
			//CommentDTO dto = new CommentDTO(postId, writerId, comments, date);
			
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
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		//commentList = service.getCommentList((int)request.getAttribute("board_num"));
		commentList = service.getCommentList(1); //개인 TEST 용
		
		request.setAttribute("cList", commentList);
		
		String view = "/WEB-INF/jsp/writeview.jsp"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}