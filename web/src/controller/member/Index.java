package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.board.BoardDao;
import vo.board.BoardVo;

@WebServlet("/index")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		List<BoardVo> list =  BoardDao.getInstance().readList(page);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.getRequestDispatcher("common/index.jsp").forward(req, resp);
	}
}
