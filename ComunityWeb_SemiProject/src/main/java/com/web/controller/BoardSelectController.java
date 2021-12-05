package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.BoardDTO;
import com.web.model.BoardService;
import com.web.model.MainpageDTO;


@WebServlet("/BoardSelectController")
public class BoardSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer board_select = Integer.parseInt(request.getParameter("board_num")); //보드 번호 받아오기
		Integer page_num = Integer.parseInt(request.getParameter("page_num")); //페이지수 받아오기
		
		BoardService service = new BoardService();
		if(board_select != null) {
			System.out.println("선택한 카테고리: " + board_select);
			List<BoardDTO> datas = service.searchBoard(board_select, page_num);//서비스에서 선택한 게시판의 글 불러오기
		}
	}

}
