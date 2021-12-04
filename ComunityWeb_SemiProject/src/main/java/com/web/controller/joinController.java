package com.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.AccountDTO;
import com.web.model.AccountService;

@WebServlet("/join")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/account/joinMember.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String UserID = request.getParameter("UserID");
		String UserPassword = request.getParameter("UserPassword");
		
		AccountDTO dto = new AccountDTO(UserID, UserPassword);
		AccountService service = new AccountService();
		if(service.add(dto)) {
			response.sendRedirect("/");
		} else {//DB내에서 잘못된 값 감지

			request.setAttribute("init", dto);
			String view = "/WEB-INF/jsp/account/joinMember.jsp";

			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
