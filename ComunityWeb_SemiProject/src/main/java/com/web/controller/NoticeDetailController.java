package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.NoticeManageDAO;

@WebServlet("/notice")
public class NoticeDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	NoticeManageDAO manage = new NoticeManageDAO();

        int postNum = Integer.parseInt(req.getParameter("postNum"));

        req.setAttribute("detail", manage.getCurrentPage(postNum));

        req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeDetail.jsp").forward(req, resp);
    }

}
