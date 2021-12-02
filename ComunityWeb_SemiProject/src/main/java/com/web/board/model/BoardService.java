package com.web.board.model;

import java.util.List;

public class BoardService {
	
	public List<BoardDTO> searchAll(int board_num){  
		BoardDAO dao = new BoardDAO();
		return dao.select(board_num);
		
	}
}