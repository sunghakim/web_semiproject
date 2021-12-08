package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.*;



@WebServlet("/")
public class MainpageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int one_page = 1;
		String page_num_str = "";
		
		page_num_str = request.getParameter("page_num"); //페이지수 받아오기
		MainpageService service = new MainpageService();//서비스 불러오기
		 
		if(!(page_num_str == null || page_num_str =="")) {
			int page_num = Integer.parseInt(page_num_str);
			List<MainpageDTO> mainlist = service.searchPage(page_num); //전체 카테고리 게시글 10개 받아오기
			request.setAttribute("boardlist", mainlist ); //메인.jsp 콘텐츠에 전체게시판 리스트 셋
		} else {
			List<MainpageDTO> mainlist = service.searchPage(one_page);
			request.setAttribute("boardlist", mainlist);
		}
		
		BoardManageDAO category = new BoardManageDAO(); //카테고리 받아오는것
		List<BoardManageDTO> cate_list = category.boardList(); //list 컬렉션으로 board_num, board_name 넣기
		request.setAttribute("datas", cate_list); //메인.jsp 카테고리에 게시판 리스트 가져오기
		
		String view = "WEB-INF/jsp/main/main.jsp"; //포워드 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
