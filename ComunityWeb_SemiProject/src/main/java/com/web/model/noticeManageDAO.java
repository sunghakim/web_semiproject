package com.web.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class noticeManageDAO {
    //db 주소
    private String dbURL = "";
    private String dbID = "";
    private String dbPassword = "";

    public noticeManageDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<PostDTO> noticeList() {
        List<PostDTO> noticeList = new ArrayList<>();
        String SQL = "SELECT POST_NUM,USER_ID,POST_TITLE,POST_DATE FROM POSTDB WHERE BOARD_NUM = 0";

        try (// db 접속, 쿼리 try-with-resource 사용
             Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                PostDTO notice = new PostDTO();
                notice.setBoard_num(rs.getInt(1));
                notice.setPost_title(rs.getString(2));
                notice.setUser_id(rs.getString(3));
                notice.setPost_date(rs.getDate(4));
                noticeList.add(notice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return noticeList;
    }


}
