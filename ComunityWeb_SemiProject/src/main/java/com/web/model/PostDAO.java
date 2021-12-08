package com.web.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.web.model.PostDTO;

public class PostDAO {
	OracleConnect oc = null;
	
	public PostDAO() {
		this.oc = new OracleConnect(false); //데이터베이스 연결한것 로컬은 false
	}
	
	public boolean add(PostDTO dto) { //게시글 추가 작업
		String query = "INSERT INTO POSTDB VALUES(POSTNUM_SEQ.NEXTVAL, "
				+ "'" + dto.getUser_id() + "', "
				+ "'" + dto.getPost_title() + "', "
				+ "'" + dto.getPost_content() + "', "
				+ "TO_DATE('" + dto.getPost_date() + "', 'YYYY-MM-DD'), "
				+ "'" + dto.getBoard_num() + "')";
		
				
		int res = oc.insert(query);
		
		return res == 1? true : false; //추가작업 성공하면 커밋 못하면 롤백.
	}
	
	public List<PostDTO> getList() {
		String query = "SELECT * FROM POSTDB ORDER BY POST_NUM DESC"; //postdb 테이블 조회
		
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
	
	//승원 작업
	//USER_ID를 기준으로 작성된 게시글 갯수 반환
	public int searchUsersAllPosts(AccountDTO dto) {
		String query = "SELECT POST_NUM FROM POSTDB WHERE USER_ID = '" + dto.getUserID() + "'";
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
	//USER_ID를 기준으로 작성된 게시글 삭제
	public int deleteUsersAllPosts(AccountDTO dto) {
	String query = "DELETE FROM POSTDB WHERE USER_ID = '" + dto.getUserID() + "'";
		return oc.delete(query);
	}
}
