package com.web.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlist")
public class UserManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserManagement manage;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		manage = new UserManagement();
		
		req.setAttribute("userList", manage.userList());
		req.getRequestDispatcher("memberlist.jsp").forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] deleteIdList = req.getParameterValues("deleteUserId");
		
		for(String s : deleteIdList)
			System.out.print("넘겨받은 아이디 :" + s + " ");
		
		manage.userDelete(deleteIdList);
		resp.sendRedirect("UserManagement");
	}

}
