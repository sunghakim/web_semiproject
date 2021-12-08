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
		String view = "/WEB-INF/jsp/account/join.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String UserID = request.getParameter("UserID");
		String UserPassword = request.getParameter("UserPassword");
		String ConfirmUserPassword = request.getParameter("ConfirmUserPassword");
		
		String view = "/WEB-INF/jsp/account/join.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		
		AccountDTO dto = new AccountDTO(UserID, UserPassword);
		AccountService service = new AccountService();
		
		if (UserPassword.equals(ConfirmUserPassword)) {
			//비밀번호와 재확인비밀번호가 같음
			if(service.checkID(dto) == 0) {
				//중복되는 아이디 없음
				if(service.add(dto)) {
					//회원가입 성공
					response.sendRedirect("/");
				} else {
					//DB내에서 잘못된 값 감지
					request.setAttribute("UserID", UserID);
					request.setAttribute("result", "1");
					rd.forward(request, response);
				}
			} else if(service.checkID(dto) == 1) {
				//중복되는 아이디 발견
				request.setAttribute("UserID", UserID);
				request.setAttribute("result", "2");
				rd.forward(request, response);
			} else {
				//DB내에서 잘못된 데이터 검출
				request.setAttribute("UserID", UserID);
				request.setAttribute("result", "1");
				rd.forward(request, response);
			}
		} else {
			//입력한 비밀번호와 재확인용 비밀번호가 같지 않음
			request.setAttribute("UserID", UserID);
			request.setAttribute("result", "3");
			rd.forward(request, response);
		}
		
	}
}
