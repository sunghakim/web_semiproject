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

@WebServlet("/changepsw")
public class changePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("result", "null");
		String view = "/WEB-INF/jsp/account/changepsw.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserPassword = request.getParameter("UserPassword");
		String NewUserPassword = request.getParameter("NewUserPassword");
		
		HttpSession session = request.getSession();
		String UserID = (String) session.getAttribute("UserID");
		
		AccountService service = new AccountService();
		AccountDTO dto = new AccountDTO(UserID, UserPassword, NewUserPassword);
		
		String view = "/WEB-INF/jsp/account/mypage.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		switch(service.updatePassword(dto)) {
		case (1):
			//변경 성공
			request.setAttribute("result", "CPsuccess");
			rd.forward(request, response);
			break;
		case (2):
			//변경 실패 - 쿼리문 에러
			request.setAttribute("result", "CPfailure1");
			view = "/WEB-INF/jsp/account/changepsw.jsp";
			rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			break;
		case (3):
			//현재 비밀번호 다름
			request.setAttribute("result", "CPfailure2");
			view = "/WEB-INF/jsp/account/changepsw.jsp";
			rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			break;
		case (4):
			//데이터베이스에서 중복된 값 오류 검출
			request.setAttribute("result", "CPfailure3");
			view = "/WEB-INF/jsp/account/changepsw.jsp";
			rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			break;
		}
	}
}
