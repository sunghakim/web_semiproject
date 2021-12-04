package com.web.model;

public class BoardManageDTO {
	private int BOARD_NUM;
	private String BOARD_NAME;
	
	public BoardManageDTO(int num, String boardName){
		this.BOARD_NUM = num;
		this.BOARD_NAME = boardName;
	}
	
	public int getBOARD_NUM() {
		return BOARD_NUM;
	}
	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	public String getBOARD_NAME() {
		return BOARD_NAME;
	}
	public void setBOARD_NAME(String bOARD_NAME) {
		BOARD_NAME = bOARD_NAME;
	}
	
}
