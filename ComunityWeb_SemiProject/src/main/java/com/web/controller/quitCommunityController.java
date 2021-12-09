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
import com.web.model.MainpageDTO;
import com.web.model.MainpageService;

@WebServlet("/quitAction")
public class quitCommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String UserID = (String) session.getAttribute("UserID");
		AccountDTO dto = new AccountDTO(UserID);
		AccountService AcccountService = new AccountService();
		
		
		
		//메인페이지 접속을 위한 로직
		String page_num_str = "";
		page_num_str = request.getParameter("page_num");
		MainpageService MainpageService = new MainpageService();
		 
		if(!(page_num_str == null || page_num_str =="")) {
			int page_num = Integer.parseInt(page_num_str);
			List<MainpageDTO> mainlist = MainpageService.searchPage(page_num);
			request.setAttribute("boardlist", mainlist );
		} else {
			List<MainpageDTO> mainlist = MainpageService.searchPage(1);
			request.setAttribute("boardlist", mainlist);
		}
		
		BoardManageDAO category = new BoardManageDAO();
		List<BoardManageDTO> cate_list = category.boardList();
		request.setAttribute("datas", cate_list);
		
		//회원 탈퇴시 결과에 따라 페이지 연결
		boolean Manager = false;
		Manager = (boolean)session.getAttribute("Manager");
		if (Manager) {
			//관리자는 회원탈퇴 불가
			String view = "/WEB-INF/jsp/account/mypage.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			if (AcccountService.quitCommunity(dto)) {
				//삭제 성공
				request.setAttribute("loginStatus", false);
				session.invalidate();
				String view = "/WEB-INF/jsp/main/main.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			} else {
				//삭제 실패
				String view = "/WEB-INF/jsp/account/mypage.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}
	}
}
