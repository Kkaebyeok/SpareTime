package service.board;

import java.util.List;

import vo.board.BoardVo;

public interface BoardService {
	// CRUD
	
	void write(BoardVo board);
	
	BoardVo read(int no);
	
	public int maxPage();
	
	public int minPage();
	
	List<BoardVo> readList(int page);
	
	void mod(BoardVo board);
	
	void del(int no);
}
