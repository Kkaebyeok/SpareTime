package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;

@WebServlet("/del")
public class Del extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			new BoardDao().del(boardNo);
			resp.sendRedirect("list");
		}
	}
	
}
