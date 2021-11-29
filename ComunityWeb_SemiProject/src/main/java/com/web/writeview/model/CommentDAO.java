package com.web.writeview.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleConnect;

public class CommentDAO {
	private OracleConnect oc;
	
	public CommentDAO() {
		this.oc = new OracleConnect();
	}
	
	public List<CommentDTO> select(int boardNum) {
		String query = "SELECT * FROM COMMENTDB WHERE BOARD_NUM = '" + boardNum + "'";
		ResultSet result = oc.selectData(query);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		if(result == null) {
			
		}
		else {
			try {
				while(result.next()) {
					CommentDTO dtoSample = new CommentDTO(result.getInt("COMMENT_NUM"), result.getInt("BOARD_NUM"), result.getString("USER_ID"), result.getString("COMMENTS"), result.getDate("COMMENT_DATE"));
					commentList.add(dtoSample);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commentList;
	}
	public boolean insert(CommentDTO dto) {
		String query = "INSERT INTO COMMENTDB VALUES(COMMENTDB_SEQ.NEXTVAL, '" + dto.getWriteId() + "', '" + dto.getWriter() + "', '" + dto.getComment() + "', TO_DATE('" + dto.getCommentDate() + "', 'YYYY-MM-DD'))";
		int result = oc.insertData(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean delete(int commentId) {
		String query = "DELETE * FROM COMMENTDB WHERE COMMENT_NUM = '" + commentId + "'";
		int result = oc.deleteData(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean update(CommentDTO dto) {
		String query = "UPDATE COMMENTS, COMMENT_DATE FROM COMMENTDB WHERE COMMENT_NUM = '" + dto.getCommentId() + "'";
		int result = oc.updaetData(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	
	public void commit() {
		oc.commit();
	}
	public void rollback() {
		oc.rollback();
	}
	public void close() {
		oc.close();
	}
}
