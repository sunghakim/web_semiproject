package com.web.post.model;

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
				+ "TO_DATE('" + dto.getPost_date() + "', 'YYYY-MM-DD'),"
				+ "'" + dto.getBoard_num() + "',";
		
				
		int res = oc.insert(query);
		
		return res == 1? true : false; //추가작업 성공하면 커밋 못하면 롤백.
	}
	
	public List<PostDTO> getList() {
		String query = "SELECT * FROM POSTDB ORDER BY POSTNUM_SEQ DESC"; //postdb 테이블 조회
		
		List<PostDTO> datas = new ArrayList<PostDTO>(); //여러 데이터 담을 컬렉션
		
		ResultSet res = oc.select(query); //검색 결과 (resultSet)
		
		try {
			while(res.next()) {
				PostDTO dto = new PostDTO();
				dto.setPost_num(res.getInt("POST_NUM"));
				dto.setUser_id(res.getString("USER_ID"));
				dto.setPost_title(res.getString("POST_TITLE"));
				dto.setPost_content(res.getString("POST_CONTENT"));
				dto.setPost_date(res.getDate("POST_DATE"));
				dto.setBoard_num(res.getInt("BOARD_NUM"));
				datas.add(dto); //결과들 더하는 작업 dto에
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
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
