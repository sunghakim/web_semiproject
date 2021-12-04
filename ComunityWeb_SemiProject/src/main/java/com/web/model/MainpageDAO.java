package com.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.db.conn.OracleConnect;

public class MainpageDAO {
	private OracleConnect oc;
	
	public MainpageDAO(){
		this.oc = new OracleConnect(false); //오라클 커넥트 연결(로컬로)
	}
	
	public List<MainpageDTO> pageList(){
		
		int  n = 1; //가상의 페이지 수임 값을 받아와야함
		String query1 = "SELECT * FROM (" //페이징 기법으로 만들기 
				+ "SELECT ROW_NUMBER() OVER (ORDER BY POSTNUM_SEQ DESC) "
				+ "AS RNUM FROM POSTDB) WHERE RNUM BETWEEN '"
				+ ((n-1) * 10 + 1) +"' AND "
				+ (n * 10) + "';";
		// N page = ((n-1) * 10 +1) ~ (n * 10); 페이징 로직 
		List<MainpageDTO> pagedatas = new ArrayList<MainpageDTO>();
		ResultSet pageres = oc.select(query1);
		
		try {
			while(pageres.next()) {  //DTO 객체에 저장하고 List컬렉션인 datas에 저장.
				MainpageDTO pagedto = new MainpageDTO();
				pagedto.setPost_num(pageres.getInt("POST_NUM"));
				pagedto.setUser_id(pageres.getString("USER_ID"));
				pagedto.setPost_title(pageres.getString("POST_TITLE"));
				pagedto.setPost_date(pageres.getDate("POST_DATE"));
				pagedto.setBoard_num(pageres.getInt("BOARD_NUM"));
				pagedatas.add(pagedto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pagedatas;
	}
	
	
	public List<MainpageDTO> getList(){
		String query = "SELECT * FROM POSTDB ORDER BY POSTNUM_SEQ"; //postdb 테이블 조회
		int totalCount = 0; //게시물 수 담을 변수
				
		List<MainpageDTO> datas = new ArrayList<MainpageDTO>(); //조회 데이터 담을 변수
		
		ResultSet res = oc.select(query); //검색결과 (resultSet)
		
		try {
			while(res.next()) {  //DTO 객체에 저장하고 List컬렉션인 datas에 저장.
				MainpageDTO dto = new MainpageDTO();
				dto.setPost_num(res.getInt("POST_NUM"));
				dto.setUser_id(res.getString("USER_ID"));
				dto.setPost_title(res.getString("POST_TITLE"));
				dto.setPost_date(res.getDate("POST_DATE"));
				dto.setBoard_num(res.getInt("BOARD_NUM"));
				datas.add(dto); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	//트렌젝션
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
