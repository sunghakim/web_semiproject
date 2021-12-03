package com.web.mainpage.model;

import java.util.List;

import com.web.post.model.PostDTO;

public class MainpageService {

	public void create(MainpageDTO dto) {
		MainpageDAO dao = new MainpageDAO();
		
	}
	
	public List<MainpageDTO> searchAll() {  
		MainpageDAO dao = new MainpageDAO();
		return dao.getList(); // 모든 DAO 리스트 반환
	}
	
	public List<MainpageDTO> searchPage(){
		MainpageDAO dao = new MainpageDAO();
		return dao.pageList(); // page DAO 리스트 반환
	}
}
