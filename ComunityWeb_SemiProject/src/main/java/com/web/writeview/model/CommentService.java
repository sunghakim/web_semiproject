package com.web.writeview.model;

import java.util.*;

public class CommentService {
	public List<CommentDTO> getCommentList(int boardNum) {
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = dao.select(boardNum);
		
		return commentList;
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
	public void changeComment(CommentDTO dto) {
		
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
