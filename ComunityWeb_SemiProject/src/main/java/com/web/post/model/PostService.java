package com.web.post.model;

import java.util.List;

public class PostService {
	
	public boolean create(PostDTO dto) {
		PostDAO dao = new PostDAO();
		boolean res = dao.add(dto); //생성이 어떻게보면 데이터 추가기에 add
		
		if(res) { //참이면 커밋 거짓이면 롤백 
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();//클로즈
		
		return res; //res는 참 거짓
		
	}
	

	public List<PostDTO> searchAll() { 
		PostDAO dao = new PostDAO();
		return dao.getList(); //DAO 리스트 반환
	}

}