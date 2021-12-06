package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.noticeManageDAO;


@WebServlet("/noticeManageController")
public class noticeManageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private noticeManageDAO manage;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        manage = new noticeManageDAO();
        req.setAttribute("datas", manage.noticeList());
        req.getRequestDispatcher("/WEB-INF/boardList.jsp").forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
