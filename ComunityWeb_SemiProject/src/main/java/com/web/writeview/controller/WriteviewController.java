package com.web.writeview.controller;

import java.io.IOException;
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
		
		String view = "/WEB-INF/jsp/writeview/views";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = (int)request.getAttribute("게시글번호");
		String writerId = (String)request.getAttribute("작성자id");
		String comments = request.getParameter("댓글내용");
		String date = request.getParameter("날짜");
		
		CommentDTO dto = new CommentDTO(postId, writerId, comments, date);
		CommentService service = new CommentService();
		if(service.isValid(dto)) {
			if(service.addComment(dto)) {
				//정상적으로 db에 저장됨.
			}
			else {
				//db에 저장 안됨 (오류 발생 알람)
			}
		}
		else {
			//댓글이 없습니다. (알람)
		}
		
		String view = "/WEB-INF/jsp/writeview/views";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}

/*
요청해야될 사항 : 
	COMMENT_NUM 에 시퀀스 처리 해줄것.
	OracleConnect 문서 새로 받을 것
	게시글 수정 페이지는 게시글 입력페이지를 이용할 것인지? 아니면 새로운 페이지?
	댓글 수정은 수정을 누르면 리스트는 그대로인데 댓글 쓰기 칸에 수정 누른 댓글 내용을 불러오기? 아니면 원래 댓글은 사라진 리스트를 보여주면서 댓글 쓰기 칸에 수정 누른 댓글 내용을 불러오기? 아니면 새로운 수정용 페이지?
	게시글 삭제, 댓글 삭제는 버튼 누르면 쿠키작업처럼 redirect 시키자.

*/