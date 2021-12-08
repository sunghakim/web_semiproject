package com.web.model;

import java.util.List;

import com.web.model.PostDTO;

public class MainpageService {
	
	public List<MainpageDTO> searchPage(int page_num){
		MainpageDAO dao = new MainpageDAO();
		return dao.pageList(page_num); // page DAO 리스트 반환
		
	}
}
