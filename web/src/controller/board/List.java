package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import vo.board.BoardVo;

@WebServlet("/list")
public class List extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pageStr = req.getParameter("page");
		int page = pageStr == null || pageStr.equals("") ? 1 : Integer.parseInt(req.getParameter("page"));
		java.util.List<BoardVo> list = BoardDao.getInstance().readList(page);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.setAttribute("maxPage", BoardDao.getInstance().maxPage());
		req.setAttribute("minPage", BoardDao.getInstance().minPage());
		req.getRequestDispatcher("board/list.jsp").forward(req, resp);
	}
}
