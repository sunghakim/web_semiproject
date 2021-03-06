package com.web.controller;

import java.io.IOException;
import java.util.*;

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
		String postNum = request.getParameter("post_id");
		if(postNum == null) { //post_id 라는 parameter가 없으면(일반 글쓰기이면)
			BoardManageDAO category = new BoardManageDAO();
			List<BoardManageDTO> cate_list = category.boardList();
			cate_list.remove(0);
			
			request.setAttribute("category", cate_list);
		}
		else { //글 수정이면
			PostService service = new PostService();
			PostDTO dto = service.searchPost(Integer.parseInt(postNum));
			
			BoardManageDAO cate_dao = new BoardManageDAO();
			List<BoardManageDTO> cate_list = cate_dao.boardList();
			String cate_name = "";
			for(BoardManageDTO find: cate_list) {
				if(find.getBOARD_NUM() == dto.getBoard_num()) {
					cate_name = find.getBOARD_NAME();
					break;
				}
			}
			
			BoardManageDTO b_dto = new BoardManageDTO(dto.getBoard_num(), cate_name);
			List<BoardManageDTO> category = new ArrayList<BoardManageDTO>();
			category.add(b_dto);
			
			request.setAttribute("post_id", Integer.parseInt(postNum));
			request.setAttribute("post_title", dto.getPost_title());
			request.setAttribute("post_content", dto.getPost_content());
			request.setAttribute("category", category); // 원래 카테고리 하나만 보이게 함.
		}		
		
		String view = "/WEB-INF/jsp/board/boardWrite.jsp"; //게시글 리스트 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글이 깨져서 들어와서 해결방안
		
		HttpSession session = request.getSession();
		String writerId = (String)session.getAttribute("UserID");

		String postTitle = request.getParameter("title");
		String postContent = request.getParameter("content");
		String postDate = request.getParameter("date");
		String postBoard = request.getParameter("board");
		String postNum = request.getParameter("post_id");
		
		PostService service = new PostService();
		
		if(postNum == null || postNum == "") {
			PostDTO dto = new PostDTO();
			dto.setUser_id(writerId);
			dto.setPost_title(postTitle);
			dto.setPost_content(postContent);
			dto.setPost_date(postDate);
			dto.setBoard_num(Integer.parseInt(postBoard));
			
			if(service.create(dto)) {
				//새글 저장 성공
			}
			else {
				//새글 저장 실패
			}
		}
		else {
			PostDTO dto = new PostDTO();
			dto.setPost_num(Integer.parseInt(postNum));
			dto.setPost_title(postTitle);
			dto.setPost_content(postContent);
			dto.setPost_date(postDate);
			
			if(service.changePost(dto)) {
				//수정글 저장 성공
			}
			else {
				//수정글 저장 실패
			}
		}
		
		
		int board_select = Integer.parseInt(postBoard);
		int page_num = 1;
		
		request.setAttribute("board_num", board_select);
		request.setAttribute("page_num", page_num);
		
		BoardService b_service = new BoardService(); //보드 서비스 불러오기
		List<BoardDTO> datas = b_service.searchBoard(board_select, page_num); //게시판넘버랑 게시글 번호 매개변수 받아서 게시글 불러오기 
		request.setAttribute("datas", datas); //게시글 리스트를 셋
		
		BoardManageDAO category = new BoardManageDAO(); //카테고리 받아오는것
		List<BoardManageDTO> cate_list = category.boardList();
		request.setAttribute("cate_list", cate_list);
		
		int postAmount = b_service.searchBoardPostNum(board_select);
		int pagingNum = 0;
		if(postAmount%10 == 0) {
			pagingNum = postAmount/10;
		}
		else {
			pagingNum = (postAmount/10) + 1;
		}
		request.setAttribute("paging_num", pagingNum);
		
		String view = "/WEB-INF/jsp/board/boardList.jsp"; //게시글 리스트 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
