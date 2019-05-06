package controller.fboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.fboard.FboardDao;
import vo.fboard.FboardVo;

@WebServlet("/fview")
public class Fview extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			Integer sum = Integer.parseInt(req.getParameter("no"));
			FboardVo board = new FboardDao().read(sum);
			req.setAttribute("fboard", board);
			req.getRequestDispatcher("fboard/fview.jsp").forward(req, resp);
		}
	}
}
