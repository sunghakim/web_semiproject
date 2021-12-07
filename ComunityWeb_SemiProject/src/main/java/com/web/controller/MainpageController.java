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



@WebServlet("/MainpageController")
public class MainpageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int one_page = 1;
		Integer page_num = Integer.parseInt(request.getParameter("page_num")); //페이지수 받아오기
		
		MainpageService service = new MainpageService();//서비스 불러오기
		List<MainpageDTO> datas = service.searchPage(page_num); //전체 카테고리 게시글 10개 받아오기
		
		request.setAttribute("datas", datas); //리스트 datas를 리퀘스트 객체에 셋
		String view = "WEB-INF/jsp/board/mainpage.jsp"; //포워드 페이지
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
