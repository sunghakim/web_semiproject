package com.web.model;

import java.sql.Date;

public class BoardDTO {

	private int post_num; //게시글 번호
	private String user_id; //유저 아이디
	private String post_title; //게시글 제목
	private String post_content; //게시글 내용
	private Date post_date; //게시글 날짜
	private int board_num; //게시판 번호
	
	public BoardDTO() {}
	public BoardDTO(int board_num) {
		this.board_num = board_num;///
	}
	
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	
	
	
	
}
