package controller.fboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.fboard.FboardDao;
import vo.fboard.FboardVo;

@WebServlet("/flist")
public class Flist extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String pageStr = req.getParameter("page");
		int page = pageStr == null || pageStr.equals("") ? 1 : Integer.parseInt(req.getParameter("page"));
		java.util.List<FboardVo> list = FboardDao.getInstance().readList(page);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.setAttribute("maxPage", FboardDao.getInstance().maxPage());
		req.setAttribute("minpage", FboardDao.getInstance().minPage());
		req.getRequestDispatcher("fboard/flist.jsp").forward(req, resp);
	}
}
