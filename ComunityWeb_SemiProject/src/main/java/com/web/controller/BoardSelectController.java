package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.BoardDTO;
import com.web.model.BoardManageDAO;
import com.web.model.BoardManageDTO;
import com.web.model.BoardService;
import com.web.model.MainpageDTO;


@WebServlet("/BoardSelectController")
public class BoardSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer board_select = Integer.parseInt(request.getParameter("board_num")); //보드 번호 받아오기
		Integer page_num = Integer.parseInt(request.getParameter("page_num")); //페이지수 받아오기
		
		BoardService service = new BoardService(); //보드 서비스 불러오기
		List<BoardDTO> datas = service.searchBoard(board_select, page_num); //게시판넘버랑 게시글 번호 매개변수 받아서 게시글 불러오기 
		request.setAttribute("datas", datas); //게시글 리스트를 셋
		
		int postNum = service.searchBoardPostNum(board_select);
		int pagingNum = 0;
		if(postNum%10 == 0) {
			pagingNum = postNum/10;
		}
		else {
			pagingNum = (postNum/10) + 1;
		}
		System.out.println(postNum + "|" + pagingNum);
		request.setAttribute("paging_num", pagingNum);
		
		request.setAttribute("board_num", board_select );
		request.setAttribute("page_num", page_num );
		
		BoardManageDAO category = new BoardManageDAO(); //카테고리 받아오는것
		List<BoardManageDTO> cate_list = category.boardList(); //list 컬렉션으로 board_num, board_name 받아오기
		request.setAttribute("cate_list", cate_list); //메인.jsp 카테고리에 게시판 리스트 셋
		
		System.out.println(board_select);
		String view = "WEB-INF/jsp/board/boardList.jsp"; //포워드 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response); //포워드
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
