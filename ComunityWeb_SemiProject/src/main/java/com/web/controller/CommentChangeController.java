package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.*;

@WebServlet("/CommentChange")
public class CommentChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("comment_id"));
		request.setAttribute("comment_id", commentId);
		
		CommentService service = new CommentService();
		CommentDTO dto = new CommentDTO();
		dto = service.getComment(commentId);
		
		request.setAttribute("comments", dto.getComment());
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = service.getCommentList(dto.getWriteId());
		
		int index = -1;
		for(int i = 0; i < commentList.size(); i++) {
			if(commentList.get(i).getCommentId() == commentId) {
				index = i;
				break;
			}
			else {}
		}
		commentList.remove(index);
		request.setAttribute("cList", commentList);
		
		PostService p_service = new PostService();
		PostDTO p_dto = p_service.searchPost(dto.getWriteId());
		request.setAttribute("post_info", p_dto);
		
		BoardManageDAO b_service = new BoardManageDAO();
		List<BoardManageDTO> b_list = b_service.boardList();
		request.setAttribute("blist", b_list);
		
		String view = "WEB-INF/jsp/board/readPost.jsp"; //게시글 상세 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
