package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.model.AccountDTO;
import com.web.model.AccountService;
import com.web.model.BoardManageDAO;
import com.web.model.BoardManageDTO;

@WebServlet("/quitAction")
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
			BoardManageDAO category = new BoardManageDAO(); //카테고리 받아오는것
			List<BoardManageDTO> cate_list = category.boardList(); //list 컬렉션으로 board_num, board_name 넣기
			request.setAttribute("datas", cate_list); //메인.jsp 카테고리에 게시판 리스트 가져오기
			
			session.invalidate();
			request.setAttribute("loginStatus", false);
			String view = "/WEB-INF/jsp/main/main.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			//삭제 실패
			request.setAttribute("result", "QCfailure");
			String view = "/WEB-INF/jsp/account/mypage.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
