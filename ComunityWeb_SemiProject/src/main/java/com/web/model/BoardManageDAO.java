package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class BoardManageDAO {
	
	private OracleConnect oc;
	
    public BoardManageDAO() {
    	oc = new OracleConnect();

    }

    public List<BoardManageDTO> boardList() {
        String SQL = "SELECT BOARD_NUM, BOARD_NAME FROM BOARDDB ORDER BY BOARD_NUM";
        
        List<BoardManageDTO> boardList = new ArrayList<>();
        
        try (Connection conn = oc.getConn();
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery()) {
        	
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
        
        
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL)) {

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
       
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL)) {

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
        
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, categoryNumber);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
