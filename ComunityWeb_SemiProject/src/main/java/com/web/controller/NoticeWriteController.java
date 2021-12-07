package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.NoticeManageDAO;

@WebServlet("/noticeWrite")
public class NoticeWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	NoticeManageDAO manage = new NoticeManageDAO();

        String view = "/WEB-INF/jsp/manager/noticeWrite.jsp";

        //넘어온 주소가 게시글 상세페이지면 noticeModify.jsp로 넘김
        if (req.getParameter("name").equals("modify")) {
            int postNum = Integer.parseInt(req.getParameter("updateNum"));
            req.setAttribute("current", manage.getCurrentPage(postNum));

            view = "/WEB-INF/jsp/manager/noticeModify.jsp";
        }

        req.getRequestDispatcher(view).forward(req, resp);
    }


}
