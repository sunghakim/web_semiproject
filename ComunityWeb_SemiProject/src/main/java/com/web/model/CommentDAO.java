package com.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleConnect;

public class CommentDAO {
	private OracleConnect oc;
	
	public CommentDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public List<CommentDTO> selectList(int postNum) {
		String query = "SELECT * FROM COMMENTDB WHERE POST_NUM = '" + postNum + "' ORDER BY COMMENT_NUM";
		ResultSet result = oc.select(query);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		if(result == null) {
			
		}
		else {
			try {
				while(result.next()) {
					CommentDTO dtoSample = new CommentDTO(result.getInt("COMMENT_NUM"), result.getInt("POST_NUM"), result.getString("USER_ID"), result.getString("COMMENTS"), result.getDate("COMMENT_DATE"));
					commentList.add(dtoSample);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commentList;
	}
	public CommentDTO select(int commentNum) {
		String query = "SELECT * FROM COMMENTDB WHERE COMMENT_NUM = '" + commentNum + "'";
		ResultSet result = oc.select(query);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		if(result == null) {
			
		}
		else {
			try {
				while(result.next()) {
					CommentDTO dtoSample = new CommentDTO(result.getInt("COMMENT_NUM"), result.getInt("POST_NUM"), result.getString("USER_ID"), result.getString("COMMENTS"), result.getDate("COMMENT_DATE"));
					commentList.add(dtoSample);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commentList.get(0);
	}
	public boolean insert(CommentDTO dto) {
		String query = "INSERT INTO COMMENTDB VALUES(COMMENTNUM_SEQ.NEXTVAL, '" + dto.getWriteId() + "', '" + dto.getWriter() + "', '" + dto.getComment() + "', TO_DATE('" + dto.getCommentDate() + "', 'YYYY-MM-DD'))";
		int result = oc.insert(query);
		
		if(result == 1) {//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean delete(int commentId) {
		String query = "DELETE FROM COMMENTDB WHERE COMMENT_NUM = '" + commentId + "'";
		int result = oc.delete(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deletePostCommentAll(int postId) {
		//게시글에 있는 댓글 삭제
		String query = "DELETE FROM COMMENTDB WHERE POST_NUM = '" + postId + "'";
		int result = oc.delete(query);
		if(result >= 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean update(CommentDTO dto) {
		String query = "UPDATE COMMENTDB SET COMMENTS = '" + dto.getComment() + "', COMMENT_DATE = TO_DATE('" + dto.getCommentDate() + "', 'YYYY-MM-DD') WHERE COMMENT_NUM = '" + dto.getCommentId() + "'";
		int result = oc.update(query);
		
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
	
	//승원 작업
	//USER_ID를 기준으로 작성된 댓글 갯수 반환
	public int searchUsersAllComments(AccountDTO dto) {
		String query = "SELECT COMMENT_NUM FROM COMMENTDB WHERE USER_ID = '" + dto.getUserID() + "'";
		ResultSet res = oc.select(query);
		int count = 0; 
		if(res == null) {
		}else {
			try {
				while(res.next()) {
					count = count + 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	//USER_ID를 기준으로 작성된 댓글 삭제
	public int deleteUsersAllComments(AccountDTO dto) {
		String query = "DELETE FROM COMMENTDB WHERE USER_ID = '" + dto.getUserID() + "'";
		return oc.delete(query);
	}
}
