package com.web.model;

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
	
	public List<BoardDTO> select(int board_num, int page_num){
		String query = "SELECT * FROM ("
				+ "SELECT ROWNUM RNUM, TB.*  FROM ("
				+ "SELECT * FROM POSTDB P JOIN BOARDDB B ON (P.BOARD_NUM = B.BOARD_NUM)  WHERE "
				+ "P.BOARD_NUM = '" + board_num +"'"
				+ "ORDER BY POST_NUM DESC )TB" 
			    + ") WHERE RNUM BETWEEN "
				+ "'" + ((page_num-1) * 10 + 1) + "'AND "
				+ "'"+ (page_num * 10) + "'" ;

		// N page = ((n-1) * 10 +1) ~ (n * 10); 페이징 로직 
		ResultSet pageres = oc.select(query);//검색 결과
		
		List<BoardDTO> datas = new ArrayList<BoardDTO>(); //여러 데이터 담을 컬렉션
		
		try {
			while(pageres.next()) { //게시글 번호, 유저아이디, 게시글 제목, 내용, 날짜, 게시판 번호
				BoardDTO dto = new BoardDTO();
				dto.setPost_num(pageres.getInt("POST_NUM"));
				dto.setUser_id(pageres.getString("USER_ID"));
				dto.setPost_title(pageres.getString("POST_TITLE"));
				dto.setPost_content(pageres.getString("POST_CONTENT"));
				dto.setPost_date(pageres.getDate("POST_DATE"));
				dto.setBoard_num(pageres.getInt("BOARD_NUM"));
				dto.setBoard_name(pageres.getString("BOARD_NAME"));
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