package com.web.writeview.model;

import java.util.*;

public class CommentService {
	public List<CommentDTO> getCommentList(int boardNum) {
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = dao.selectList(boardNum);
		
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
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteComment(int commentId) {
		CommentDAO dao = new CommentDAO();
		if(dao.delete(commentId)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean changeComment(CommentDTO dto) {
		CommentDAO dao = new CommentDAO();
		if(dao.update(dto)) {
			return true;
		}
		else {
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
