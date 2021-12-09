package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.NoticeManageDAO;

@WebServlet("/notice")
public class NoticeDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html;charset=UTF-8");
    	
    	Boolean access = (Boolean) session.getAttribute("isManager");
    	if(access == null || !access) {
    		PrintWriter pw = resp.getWriter();
    		pw.println("<script>alert('접근 불가'); location.href='';</script>");
    		pw.close();
    		return;
    	}
    	
    	NoticeManageDAO manage = new NoticeManageDAO();

    	int postNum = Integer.parseInt(req.getParameter("postNum"));

    	req.setAttribute("detail", manage.getCurrentPage(postNum));
        req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeDetail.jsp").forward(req, resp);
    }

}
