package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class BoardManageDAO {
	
	private OracleConnect oc;
	
    public BoardManageDAO() {
    	oc = new OracleConnect(true);

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
    
    
    public int updateCategory(String changeName, int currentNumber) {
        String SQL = "UPDATE BOARDDB SET BOARD_NAME = ? WHERE BOARD_NUM = ?";
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, changeName);
            pstmt.setInt(2, currentNumber);
            
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    public boolean updateCategory(String changeName, int changeCategoryNumber, int currentCategoryNumber) {
    	
    	try (Connection conn = oc.getConn()) {
    		
			if (tempCategory(changeName, changeCategoryNumber, conn) < 1) {
				System.out.println("createCategory실패");
				return false;
			}
			
			int result = updatePost(currentCategoryNumber, changeCategoryNumber, conn);
			if(result < 0) {				
				System.out.println(result);
				System.out.println("updatePost실패");
				return false;
			}
			
			if(deleteCurrentCategory(currentCategoryNumber, conn) < 1) {
				System.out.println("deleteCurrentCategory 실패");
				return false;
			}
			
			return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int deleteCategory(int categoryNumber) {
        String SQL = "DELETE FROM BOARDDB WHERE BOARD_NUM = ?";
        
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL)) {
        	
        	deletePost(categoryNumber, conn);
            pstmt.setInt(1, categoryNumber);
            
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    
    private int tempCategory(String name, int number, Connection conn) {
    	String SQL = "INSERT INTO BOARDDB VALUES(?, ?)";

    	try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

               pstmt.setInt(1, number);
               pstmt.setString(2, name);
               return pstmt.executeUpdate();

           } catch (SQLException e) {
               e.printStackTrace();
           }
		return -1;
    }
    
    private int updatePost(int current, int next, Connection conn) {
		String SQL = "UPDATE POSTDB SET BOARD_NUM = ? WHERE BOARD_NUM = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, next);
			pstmt.setInt(2, current);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
    
    private int deletePost(int categoryNumber, Connection conn) {
		String SQL = "DELETE POSTDB WHERE BOARD_NUM = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			
			pstmt.setInt(1, categoryNumber);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
    
    private int deleteCurrentCategory(int current, Connection conn) {
    	String SQL = "DELETE FROM BOARDDB WHERE BOARD_NUM = ?";
    	try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

               pstmt.setInt(1, current);
               return pstmt.executeUpdate();

           } catch (SQLException e) {
               e.printStackTrace();
           }

    	return -1;
    	
    }
    
    

}
