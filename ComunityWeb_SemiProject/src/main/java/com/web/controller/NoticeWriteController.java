package com.web.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.*;

@WebServlet("/noticeWrite")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeManageDAO manage;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeWrite.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println(title + content);
		manage = new NoticeManageDAO();
		
		PostDTO post = new PostDTO();
		
		post.setUser_id("manager");
		post.setPost_title(title);
		post.setPost_content(content);
		post.setPost_date(new Date(System.currentTimeMillis()));
		post.setBoard_num(0);
		
		
		if(manage.postNotice(post) >= 1) {
			System.out.println("공지사항 작성 성공");
			resp.sendRedirect("noticeList");
			return;
		}
		
		System.out.println("공지사항 작성 실패");
		resp.sendRedirect("noticeList");
	}

}
