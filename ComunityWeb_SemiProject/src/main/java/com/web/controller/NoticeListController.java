package com.web.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.NoticeManageDAO;
import com.web.model.PostDTO;


@WebServlet("/noticeList")
public class NoticeListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeManageDAO noticeManage;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        noticeManage = new NoticeManageDAO();

        req.setAttribute("postList", noticeManage.noticeList());
        req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeList.jsp").forward(req, resp);

    }

    // 게시글 작성, 수정
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        noticeManage = new NoticeManageDAO();

        String send = req.getParameter("send");

        switch (send) {
            case "write": {
                String title = req.getParameter("title");
                String content = req.getParameter("content");

                PostDTO post = new PostDTO();
                post.setUser_id("manager");
                post.setPost_title(title);
                post.setPost_content(content);
                post.setPost_date(new Date(System.currentTimeMillis()));
                post.setBoard_num(0);

                if (noticeManage.postNotice(post) >= 1) {
                    System.out.println("공지사항 작성 성공");
                    resp.sendRedirect("noticeList");
                    return;
                }
                break;
            }
            case "modify": {
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                int num = Integer.parseInt(req.getParameter("num"));
                if (noticeManage.updatePost(title, content, num) >= 1) {
                    System.out.println("수정 성공");
                    resp.sendRedirect("notice?postNum=" + num);
                    return;
                }
                break;
            }
            case "delete": {
                int delete = Integer.parseInt(req.getParameter("deletePost"));
                if (noticeManage.deletePost(delete) >= 1) {
                    System.out.println("삭제 성공");
                    resp.sendRedirect("noticeList");
                    return;
                }
                break;
            }
        }


        System.out.println("작성, 수정, 삭제 실패");
        resp.sendRedirect("noticeList");
    }


}
