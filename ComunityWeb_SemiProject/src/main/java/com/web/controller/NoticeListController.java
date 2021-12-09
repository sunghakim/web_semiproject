package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.NoticeManageDAO;
import com.web.model.PostDTO;


@WebServlet("/noticeList")
public class NoticeListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	NoticeManageDAO noticeManage = new NoticeManageDAO();
    	
        req.setAttribute("postList", noticeManage.noticeList());
        req.getRequestDispatcher("/WEB-INF/jsp/manager/noticeList.jsp").forward(req, resp);

    }

    // 게시글 작성, 수정
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("UserID");
        NoticeManageDAO noticeManage = new NoticeManageDAO();
        String send = req.getParameter("send");

        switch (send) {
            case "write": {
                String title = req.getParameter("title");
                String content = req.getParameter("content");

                PostDTO post = new PostDTO();
                post.setUser_id(id);
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
            	String writer = req.getParameter("Writer");
            	System.out.println(writer.equals(id));
            	
            	if(!writer.equals(id)) {
            		PrintWriter pw = resp.getWriter();
            		pw.println("<script>alert('아이디가 달라 수정 불가'); location.href='"+"noticeList" +"';</script>");
            		pw.close();
            		return;
            	}
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
            	String writer = req.getParameter("postWriter");
            	
            	if(!writer.equals(id)) {
            		PrintWriter pw = resp.getWriter();
            		pw.println("<script>alert('아이디가 달라 삭제 불가'); location.href='"+"noticeList" +"';</script>");
            		pw.close();
            		return;
            	}
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
