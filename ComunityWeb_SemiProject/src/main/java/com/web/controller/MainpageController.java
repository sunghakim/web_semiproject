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
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page_num = Integer.parseInt(request.getParameter("page_num")); //페이지수 받아오기
		
		MainpageService service = new MainpageService(); //서비스 불러오기
		List<MainpageDTO> datas = service.searchPage(page_num); //전체 게시글 불러오기(페이지수 보고)
	}

}
