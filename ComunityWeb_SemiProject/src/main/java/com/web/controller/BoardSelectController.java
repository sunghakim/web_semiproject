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


@WebServlet("/board")
public class BoardSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer board_select = Integer.parseInt(request.getParameter("board_select")); //보드 번호 받아오기
		Integer page_num = Integer.parseInt(request.getParameter("page_num")); //페이지수 받아오기
		BoardService service = new BoardService();
		List<BoardDTO> datas = service.searchBoard(board_select, page_num);
		
		BoardManageDAO category = new BoardManageDAO(); //카테고리 받아오는것
		List<BoardManageDTO> cate_list = category.boardList(); //list 컬렉션으로 board_num, board_name 넣기
		request.setAttribute("cate_list", cate_list); //메인.jsp 카테고리에 게시판 리스트 가져오기
		
		request.setAttribute("datas", datas); //리스트 datas를 리퀘스트 객체에 셋
		String view = "WEB-INF/jsp/board/boardList.jsp"; //포워드 페이지(
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
