package com.web.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class NoticeManageDAO {
	private OracleConnect oc;
    public NoticeManageDAO() {
        oc = new OracleConnect(false);
    }

    public List<PostDTO> noticeList() {
        List<PostDTO> noticeList = new ArrayList<>();
        String SQL = "SELECT POST_NUM,USER_ID,POST_TITLE,POST_DATE FROM POSTDB WHERE BOARD_NUM = 0 ORDER BY POST_NUM DESC";

        try (Connection conn = oc.getConn();
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                PostDTO notice = new PostDTO();
                notice.setPost_num(rs.getInt(1));
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

    public int postNotice(PostDTO notice) {
        String SQL = "INSERT INTO POSTDB VALUES(POSTNUM_SEQ.NEXTVAL,?,?,?,TO_DATE(?),0)";
        try (Connection conn = oc.getConn();
             PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setString(1, notice.getUser_id());
            pstmt.setString(2, notice.getPost_title());
            pstmt.setString(3, notice.getPost_content());
            pstmt.setDate(4, notice.getPost_date());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public PostDTO getCurrentPage(int postNum) {
        String SQL = "SELECT POST_TITLE,POST_DATE,POST_CONTENT FROM POSTDB WHERE POST_NUM = ?";
        try (Connection conn = oc.getConn();
             PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setInt(1, postNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                PostDTO post = new PostDTO();
                post.setPost_title(rs.getString(1));
                post.setPost_date(rs.getDate(2));
                post.setPost_content(rs.getString(3));
                post.setPost_num(postNum);

                return post;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int updatePost(String title, String content, int num) {
        String SQL = "UPDATE POSTDB SET POST_TITLE = ?, POST_CONTENT = ? WHERE POST_NUM = ?";
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL);) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, num);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }

    public int deletePost(int delete) {
        String SQL = "DELETE FROM POSTDB WHERE POST_NUM = ?";
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setInt(1, delete);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }

}
