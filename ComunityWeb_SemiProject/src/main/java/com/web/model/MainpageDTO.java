package com.web.model;

import java.sql.Date;

public class MainpageDTO {
	private int post_num; //게시글 이름
	private String user_id; //유저 아이디
	private String post_title; //게시글 제목
	private Date post_date; //게시글 날짜
	private int board_num; //게시판 번호
	private String board_name;
	
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
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
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	
}
	
	
	
	