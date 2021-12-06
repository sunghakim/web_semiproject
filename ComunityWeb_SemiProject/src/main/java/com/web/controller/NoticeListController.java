package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.BoardManageDAO;
import com.web.model.NoticeManageDAO;


@WebServlet("/noticeList")
public class NoticeListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeManageDAO noticeManage;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        noticeManage = new NoticeManageDAO();
        
        req.setAttribute("postList", noticeManage.noticeList());
        req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeList.jsp").forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }

}
