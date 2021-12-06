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
	
	public List<MainpageDTO> pageList(int page_num){
		
		String query = "SELECT P.POST_NUM, P.USER_ID, P.POST_TITLE, P.POST_DATE, B.BOARD_NAME FROM (" //페이징 기법으로 만들기 
				+ "SELECT ROW_NUMBER() OVER (ORDER BY POSTNUM_SEQ DESC) "
				+ "AS RNUM FROM POSTDB P JOIN BOARDDB B ON (P.BOARD_NUM = B.BOARD_NUM) WHERE RNUM BETWEEN '"
				+ ((page_num - 1) * 10 + 1) +"' AND "
				+ (page_num * 10) + "';";
		// N page = ((n-1) * 10 +1) ~ (n * 10); 페이징 로직 
		List<MainpageDTO> pagedatas = new ArrayList<MainpageDTO>();
		ResultSet pageres = oc.select(query);
		
		try {
			while(pageres.next()) {  //DTO 객체에 저장하고 List컬렉션인 datas에 저장.
				MainpageDTO pagedto = new MainpageDTO();
				pagedto.setPost_num(pageres.getInt("POST_NUM"));
				pagedto.setUser_id(pageres.getString("USER_ID"));
				pagedto.setPost_title(pageres.getString("POST_TITLE"));
				pagedto.setPost_date(pageres.getDate("POST_DATE"));
				pagedto.setBoard_name(pageres.getString("BOARD_NAME"));
				pagedatas.add(pagedto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pagedatas;
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
