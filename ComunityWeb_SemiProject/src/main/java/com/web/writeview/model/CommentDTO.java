package com.web.writeview.model;

import java.sql.Date;

public class CommentDTO {
	private int commentId;
	private int writeBoardId;
	private String writer;
	private String comment;
	private Date commentDate;
	
	public CommentDTO() {}
	public CommentDTO(int writeBoardId, String writer, String comment, String commentDate) {
		this.writeBoardId = writeBoardId;
		this.writer = writer;
		this.comment = comment;
		this.commentDate = Date.valueOf(commentDate);
	}
	public CommentDTO(int commentId, int writeBoardId, String writer, String comment, Date commentDate) {
		this.commentId = commentId;
		this.writeBoardId = writeBoardId;
		this.writer = writer;
		this.comment = comment;
		this.commentDate = commentDate;
	}
	public CommentDTO(int commentId, int writeBoardId, String writer, String comment, String commentDate) {
		this.commentId = commentId;
		this.writeBoardId = writeBoardId;
		this.writer = writer;
		this.comment = comment;
		this.commentDate = Date.valueOf(commentDate);
	}
	public int getCommentId() {
		return this.commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getWriteId() {
		return this.writeBoardId;
	}
	public void setWriteId(int writeBoardId) {
		this.writeBoardId = writeBoardId;
	}
	public String getWriter() {
		return this.writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentDate() {
		return this.commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = Date.valueOf(commentDate);
	}
	
	
}
