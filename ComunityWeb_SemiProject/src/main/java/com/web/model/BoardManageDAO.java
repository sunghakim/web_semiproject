package com.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardManageDAO {
    // db 주소
    private String dbURL = "jdbc:oracle:thin:@tdb_medium?TNS_ADMIN=c:\\Users\\Coder\\.";
    private String dbID = "USER2";
    private String dbPassword = "Database4321";

    public BoardManageDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<BoardManageDTO> boardList() {
        String SQL = "SELECT BOARD_NUM, BOARD_NAME FROM BOARDDB ORDER BY BOARD_NUM";
        List<BoardManageDTO> boardList = new ArrayList<>();

        try (// db 접속, 쿼리 try-with-resource 사용
             Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                boardList.add(new BoardManageDTO(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardList;
    }

    public int insertCategory(int categoryId, String categoryName) {
        String SQL = "INSERT INTO BOARDDB VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setInt(1, categoryId);
            pstmt.setString(2, categoryName);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int updateCategory(String changeName, int changeCategoryNumber, int currentCategoryNumber) {
        String SQL = "UPDATE BOARDDB SET BOARD_NAME = ?, BOARD_NUM = ? WHERE BOARD_NUM = ?";

        try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setString(1, changeName);
            pstmt.setInt(2, changeCategoryNumber);
            pstmt.setInt(3, currentCategoryNumber);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int deleteCategory(int categoryNumber) {
        String SQL = "DELETE FROM BOARDDB WHERE BOARD_NUM = ?";

        try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(SQL);) {

            pstmt.setInt(1, categoryNumber);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
