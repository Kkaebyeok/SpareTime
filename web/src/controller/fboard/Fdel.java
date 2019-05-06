package controller.fboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.fboard.FboardDao;

@WebServlet("/fdel")
public class Fdel extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			new FboardDao().del(boardNo);
			resp.sendRedirect("flist");
		}
	}
	
	
}
