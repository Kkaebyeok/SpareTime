package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import vo.board.BoardVo;

@WebServlet("/mod")
public class Mod extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			BoardVo board = new BoardDao().read(boardNo);
			req.setAttribute("board", board);
			req.getRequestDispatcher("board/mod.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardVo board = new BoardVo();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setBoardNo(boardNo);
		new BoardDao().mod(board);
		
		resp.sendRedirect("list");
	}

}
