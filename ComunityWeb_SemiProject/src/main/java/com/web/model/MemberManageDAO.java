package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class MemberManageDAO {
	
	private OracleConnect oc;
	StringBuffer id;
	
	public MemberManageDAO() {
    	oc = new OracleConnect(false);
    }

    public List<AccountDTO> memberList() {
        List<AccountDTO> memberList = new ArrayList<>();
        String SQL = "SELECT USER_ID, PASSWORD FROM ACCOUNTDB WHERE IS_MANAGER = 0 ORDER BY USER_ID";
        
        try (Connection conn = oc.getConn();
        	 PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(2);
                memberList.add(new AccountDTO(id, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;
    }

    public int memberDelete(String[] ids) {

        id = new StringBuffer();

        for (int i = 0; i < ids.length; i++) {
            id.append("'");
            id.append(ids[i]);
            id.append("'");
            if (i < ids.length - 1)
                id.append(",");
        }
        

        String SQL = "DELETE ACCOUNTDB WHERE USER_ID IN (" + id.toString() + ")";
        
                
        try (Connection conn = oc.getConn();
        	 Statement stmt = conn.createStatement();) {

        	deleteComment(conn);
        	deletePost(conn);

        	System.out.println("삭제한 ID : " + id);
            return stmt.executeUpdate(SQL);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
	private void deletePost(Connection conn) {
		String SQL = "DELETE POSTDB WHERE USER_ID IN (" + id.toString() + ")";
		try (Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteComment(Connection conn) {
		String SQL = "DELETE COMMENTDB WHERE USER_ID IN (" + id.toString() + ")";
		
		try (Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	
}
