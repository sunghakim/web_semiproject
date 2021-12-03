package com.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.account.model.AccountDTO;
import com.web.account.model.AccountService;

@WebServlet("/quitCommunity")
public class quitCommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String UserID = (String) session.getAttribute("UserID");
		AccountDTO dto = new AccountDTO(UserID);
		AccountService service = new AccountService();
		
		if (service.quitCommunity(dto)) {
			//삭제 성공
			session.invalidate();
			request.setAttribute("loginStatus", false);
			String view = "/WEB-INF/jsp/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			//삭제 실패
			request.setAttribute("result", "QCfailure");
			String view = "/WEB-INF/jsp/myPage/myPage.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
