package com.web.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberManageDAO;

@WebServlet("/memberlist")
public class memberManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberManageDAO manage;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		manage = new MemberManageDAO();
		
		req.setAttribute("datas", manage.memberList());
		req.getRequestDispatcher("/WEB-INF/jsp/manager/memberlist.jsp").forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] deleteIdList = req.getParameterValues("deleteUserId");
		
		System.out.println("넘겨받은 아이디 : ");
		for(String s : deleteIdList)
			System.out.print(s + " ");
		System.out.println();
		
		manage.memberDelete(deleteIdList);
		resp.sendRedirect("memberlist");
	}

}
