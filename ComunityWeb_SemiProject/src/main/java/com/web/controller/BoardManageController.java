package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.BoardManageDAO;

@WebServlet("/boardmanage")
public class BoardManageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BoardManageDAO manage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        manage = new BoardManageDAO();

        req.setAttribute("datas", manage.boardList());
        req.getRequestDispatcher("/WEB-INF/jsp/manager/board.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String send = req.getParameter("send");

        switch (send) {
            case "createSubmit": {
                String[] create = req.getParameterValues("create");
                int categoryId = Integer.parseInt(create[0]);
                String categoryName = create[1];

                int result = manage.insertCategory(categoryId, categoryName);

                System.out.println("쿼리 반환값 : " + result);
                System.out.println("추가한 카테고리 ID : " + create[0] + "\n카테고리 이름 : " + create[1]);
                break;

            }
            // 공지사항 카테고리 번호 = 0, 삭제 수정 불가
            case "updateSubmit": {
                String[] update = req.getParameterValues("update");
                for(String s : update) {
                	System.out.println(s+ " ");
                }
                String[] currentCategory = update[0].split(" ");
                int currentCategoryNum = Integer.parseInt(currentCategory[0]);
                String currentCategoryName = currentCategory[1];

                if (currentCategoryNum == 0) {
                    System.out.println("공지사항은 수정 불가");
                    break;
                }

                int updateCategoryNum = Integer.parseInt(update[1]);
                String updateCategoryName = update[2];


                System.out.println("수정 전 카테고리 : " + currentCategoryNum + " " + currentCategoryName);
                int result = manage.updateCategory(updateCategoryName, updateCategoryNum, currentCategoryNum);

                System.out.println("쿼리 반환값 : " + result);
                System.out.println("수정된 카테고리 : " + updateCategoryNum + " " + updateCategoryName);
                break;
            }

            case "deleteSubmit": {
                Integer delete = Integer.parseInt(req.getParameter("delete"));

                if (delete == 0) {
                    System.out.println("공지사항은 삭제 불가");
                    break;
                }

                int result = manage.deleteCategory(delete);

                System.out.println("쿼리 반환값 : " + result);
                System.out.println("지운 카테고리 : " + delete);
                break;
            }
        }

        resp.sendRedirect("board");

    }
}
