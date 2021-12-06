package com.web.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;

public class PostDAO {
	OracleConnect oc = null;
	
	public PostDAO() {
		this.oc = new OracleConnect(false); //데이터베이스 연결한것 로컬은 false
	}
	
	public boolean add(PostDTO dto) { //게시글 추가 작업
		String query = "INSERT INTO POSTDB VALUES(POSTNUM_SEQ.NEXTVAL,"
				+ "'" + dto.getUser_id() + "',"
				+ "'" + dto.getPost_title() + "',"
				+ "'" + dto.getPost_content() + "',"
				+ "SYSDATE"
				+ "'" + dto.getBoard_name() + "'";
		
				
		int res = oc.insert(query);
		
		return res == 1? true : false; //추가작업 성공하면 커밋 못하면 롤백.
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

	//성하 작업
	public PostDTO selectPost(int postNum) {
		String query = "SELECT * FROM POSTDB WHERE POST_NUM = '" + postNum + "'";
		ResultSet result = oc.select(query);
		
		List<PostDTO> postList = new ArrayList<PostDTO>();
		if(result == null) {
			
		}
		else {
			try {
				while(result.next()) {
					PostDTO dtoSample = new PostDTO();
					dtoSample.setPost_num(result.getInt("POST_NUM"));
					dtoSample.setUser_id(result.getString("USER_ID"));
					dtoSample.setPost_title(result.getString("POST_TITLE"));
					dtoSample.setPost_content(result.getString("POST_CONTENT"));
					dtoSample.setPost_date(result.getDate("POST_DATE"));
					dtoSample.setBoard_num(result.getInt("BOARD_NUM"));
					postList.add(dtoSample);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return postList.get(0);
	}
	public boolean delete(int postNum) {
		String query = "DELETE FROM POSTDB WHERE POST_NUM = '" + postNum + "'";
		int result = oc.delete(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
	public boolean update(PostDTO dto) {
		String query = "UPDATE POSTDB SET POST_TITLE = '" + dto.getPost_title() + "', POST_CONTENT = '" + dto.getPost_content() + "', POST_DATE = TO_DATE('" + dto.getPost_date() + "', 'YYYY-MM-DD') WHERE POST_NUM = '" + dto.getPost_num() + "'";
		int result = oc.update(query);
		
		if(result == 1) {
			//성공
			return true;
		}
		else {
			return false;
		}
	}
}
