package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import vo.board.BoardVo;

@WebServlet("/view")
public class View extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			BoardVo board = new BoardDao().read(Integer.parseInt(req.getParameter("no")));
			req.setAttribute("board", board);
			req.getRequestDispatcher("board/view.jsp").forward(req, resp);
		}
	}
	
}
