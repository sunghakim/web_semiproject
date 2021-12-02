package com.web.board.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class BoardDAO {

	OracleConnect oc = null;
	public BoardDAO() {
		this.oc = new OracleConnect(false); //로컬 데이터베이스 연결
	}
	
	public List<BoardDTO> select(int board_num){
		
		String query = "SELECT * FROM POSTDB WHERE BOARD_NUM = '"
				+ board_num +"'ORDER BY POSTNUM_SEQ DESC";
				
		
		List<BoardDTO> datas = new ArrayList<BoardDTO>(); //여러 데이터 담을 컬렉션
		
		ResultSet res = oc.select(query); //검색 결과 (resultSet)
		
		try {
			while(res.next()) {
				BoardDTO dto = new BoardDTO();
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