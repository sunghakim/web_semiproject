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
		String view = "/WEB-INF/jsp/account/changePassword.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserPassword = request.getParameter("UserPassword");
		String NewUserPassword = request.getParameter("newUserPassword");
		
		HttpSession session = request.getSession();
		String UserID = (String) session.getAttribute("UserID");
		
		AccountService service = new AccountService();
		AccountDTO dto = new AccountDTO(UserID, UserPassword, NewUserPassword);
		if (service.login(dto)) {//올바른 현재 비밀번호 입력시
			if (service.updatePassword(dto)) {
				//변경 성공
				request.setAttribute("result", "CPsuccess");
				String view = "/WEB-INF/jsp/myPage/myPage.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			} else {
				//변경 실패
				request.setAttribute("result", "CPfailure2");
				String view = "/WEB-INF/jsp/account/changePassword.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		} else {//잘못된 현재 비밀번호 입력시
			//변경 실패
			request.setAttribute("result", "CPfailure1");
			String view = "/WEB-INF/jsp/account/changePassword.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
