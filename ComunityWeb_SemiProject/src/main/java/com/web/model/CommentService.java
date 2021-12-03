package com.web.model;

import java.util.*;

public class CommentService {
	public List<CommentDTO> getCommentList(int postNum) {
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = dao.selectList(postNum);
		
		return commentList;
	}
	public CommentDTO getComment(int commentId) {
		CommentDAO dao = new CommentDAO();
		CommentDTO dto = new CommentDTO();
		dto = dao.select(commentId);
		
		return dto;
	}
	public boolean addComment(CommentDTO dto) {
		CommentDAO dao = new CommentDAO();
		if(dao.insert(dto)) {
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
	public boolean deleteComment(int commentId) {
		CommentDAO dao = new CommentDAO();
		if(dao.delete(commentId)) {
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
	public boolean changeComment(CommentDTO dto) {
		CommentDAO dao = new CommentDAO();
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
	public boolean isValid(CommentDTO dto) {
		if(dto.getComment() == null || dto.getComment().length() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
