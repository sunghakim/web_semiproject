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
		commentList = service.getCommentList((int)request.getAttribute("board_num"));
		
		request.setAttribute("cList", commentList);
		
		String view = "/WEB-INF/jsp/writeview/views"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = (int)request.getAttribute("게시글번호");
		String writerId = (String)request.getAttribute("작성자id");
		String comments = request.getParameter("댓글내용");
		String date = request.getParameter("date");
		String commentId = (String)request.getAttribute("댓글id");
		
		if(commentId == null) {
			CommentDTO dto = new CommentDTO(postId, writerId, comments, date);
			CommentService service = new CommentService();
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
			CommentService service = new CommentService();
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
		
		String view = "/WEB-INF/jsp/writeview/views"; //게시글 상세보기 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}

/*
요청해야될 사항 : 
	COMMENT_NUM 에 시퀀스 처리 해줄것.
	게시글 수정 페이지는 게시글 입력페이지를 이용
	댓글 수정은 수정을 누르면 사라진 리스트를 보여주면서 댓글 쓰기 칸에 수정 누른 댓글 내용을 불러오기
	게시글 삭제, 댓글 삭제는 버튼 누르면 쿠키작업처럼 redirect 시키자.

*/