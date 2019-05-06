package service.fboard;

import java.util.List;

import vo.board.BoardVo;
import vo.fboard.FboardVo;

public interface FboardService {
	// CRUD
	
	void write(FboardVo board);
	
	FboardVo read(int no);
	
	public int maxPage();
	
	public int minPage();
	
	List<FboardVo> readList(int page);
	
	void mod(FboardVo board);
	
	void del(int no);
	
}
