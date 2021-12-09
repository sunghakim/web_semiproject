package com.web.model;

import java.util.List;

public class BoardService {
	
	public List<BoardDTO> searchBoard(int board_num, int page_num){  
		BoardDAO dao = new BoardDAO();
		return dao.select(board_num, page_num);
	}
	
	public int searchBoardPostNum(int board_num) {
		BoardDAO dao = new BoardDAO();
		return dao.selectAll(board_num).size();
	}
}