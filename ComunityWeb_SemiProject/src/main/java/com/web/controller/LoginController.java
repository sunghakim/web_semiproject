package com.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.model.AccountDTO;
import com.web.model.AccountService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("result", "null");
		String view = "/WEB-INF/jsp/account/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserID = request.getParameter("UserID");
		String UserPassword = request.getParameter("UserPassword");
		AccountDTO dto = new AccountDTO(UserID, UserPassword);
		AccountService service = new AccountService();
		HttpSession session = request.getSession();
		
		switch(service.login(dto)) {
		case(1)://관리자 로그인 성공
			session.setAttribute("UserID", dto.getUserID());
			session.setAttribute("Manager", dto.getManager());
			response.sendRedirect("/memberlist");
			break;
		case(2)://일반회원 로그인 성공
			session.setAttribute("UserID", dto.getUserID());
			session.setAttribute("Manager", dto.getManager());
			response.sendRedirect("/");
			break;
		case(3):
		case(4)://로그인 실패
			request.setAttribute("UserID", UserID);
			request.setAttribute("result", "failure");
			String view = "/WEB-INF/jsp/account/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
