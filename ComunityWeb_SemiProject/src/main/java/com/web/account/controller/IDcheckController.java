package com.web.account.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.account.model.AccountDTO;
import com.web.account.model.AccountService;

@WebServlet("/IDcheck")
public class IDcheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//새 창을 띄워서 작동하도록 해야한다. (자바스크립트와 연계 필요)
		String view = "/WEB-INF/jsp/account/IDcheck.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserID = request.getParameter("UserID");
		AccountDTO dto = new AccountDTO(UserID);
		AccountService service = new AccountService();
		
		if(service.checkID(dto) == 0) {
			//중복되는 아이디 없음
			request.setAttribute("UserID", dto.getUserID());
			request.setAttribute("result", "0");
			String view = "/WEB-INF/jsp/account/IDcheck.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else if(service.checkID(dto) == 1) {
			//중복되는 아이디 발견
			request.setAttribute("UserID", dto.getUserID());
			request.setAttribute("result", "1");
			String view = "/WEB-INF/jsp/account/IDcheck.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			//DB내에서 잘못된 데이터 검출
		}
		
	}

}
