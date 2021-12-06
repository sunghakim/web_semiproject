package com.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String UserID = "";
		if(session.getAttribute("UserID") != null) {
			UserID = (String) session.getAttribute("UserID");
		}
		if(UserID.equals("")) {
			// 로그아웃 상태
			request.setAttribute("loginStatus", false);
		} else {
			// 로그인 상태
			request.setAttribute("loginStatus", true);
		}
		String view = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
