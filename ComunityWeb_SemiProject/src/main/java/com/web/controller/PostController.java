package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.*;

@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardManageDAO category = new BoardManageDAO();
		List<BoardManageDTO> cate_list = category.boardList();
		
		request.setAttribute("category", cate_list);
		
		String view = "/WEB-INF/jsp/board/boardWrite.jsp"; //게시글 리스트 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String writerId = (String)session.getAttribute("UserID");

		String postTitle = request.getParameter("title");
		String postContent = request.getParameter("content");
		String postDate = request.getParameter("date");
		String postBoard = request.getParameter("board");
		String postNum = request.getParameter("post_id");
		
		PostService service = new PostService();
		if(postNum == null) {
			PostDTO dto = new PostDTO();
			dto.setUser_id(writerId);
			dto.setPost_title(postTitle);
			dto.setPost_content(postContent);
			dto.setPost_date(postDate);
			dto.setBoard_num(Integer.parseInt(postBoard));
			
			if(service.create(dto)) {
				System.out.println("새글 저장 성공");
			}
			else {
				System.out.println("새글 저장 실패");
			}
		}
		else {
			PostDTO dto = new PostDTO();
			dto.setPost_num(Integer.parseInt(postNum));
			dto.setPost_title(postTitle);
			dto.setPost_content(postContent);
			dto.setPost_date(postDate);
			
			if(service.changePost(dto)) {
				System.out.println("수정글 저장 성공");
			}
			else {
				System.out.println("수정글 저장 실패");
			}
		}
		
		List<PostDTO> datas = service.searchAll(); //리스트 가져오기
		request.setAttribute("datas", datas);
		
		String view = "/WEB-INF/jsp/board/boardList.jsp"; //게시글 리스트 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
