package com.web.model;

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
	
	//성하 작업
	public PostDTO searchPost(int postNum) {
		PostDAO dao = new PostDAO();
		PostDTO dto = new PostDTO();
		dto = dao.selectPost(postNum);
		
		return dto;
	}
	public int deletePost(int postNum) {
		PostDAO p_dao = new PostDAO();
		CommentDAO c_dao = new CommentDAO();
		List<CommentDTO> c_List = c_dao.selectList(postNum);
		System.out.println(c_List.size());
		if(c_List.size() == 0) {
			//댓글 없으면
			if(p_dao.delete(postNum)) {
				p_dao.commit();
				p_dao.close();
				return 0; //성공
			}
			else {
				p_dao.rollback();
				p_dao.close();
				return 1; //게시글 삭제 실패
			}
		}
		else {
			if(c_dao.deletePostCommentAll(postNum)) {
				c_dao.commit();
				c_dao.close();
				if(p_dao.delete(postNum)) {
					p_dao.commit();
					p_dao.close();
					return 0; //성공
				}
				else {
					p_dao.rollback();
					p_dao.close();
					return 1; //게시글 삭제 실패
				}
			}
			else {
				c_dao.rollback();
				c_dao.close();
				return 2; //게시글에 있는 댓글 삭제 실패
			}
		}
	}
	public boolean changePost(PostDTO dto) {
		PostDAO dao = new PostDAO();
		if(dao.update(dto)) {
			dao.commit();
			dao.close();
			return true;
		}
		else {
			dao.rollback();
			dao.close();
			return false;
		}
	}
	
}
