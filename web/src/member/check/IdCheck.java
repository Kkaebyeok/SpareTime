package member.check;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;

@WebServlet("/idcheck")
public class IdCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int result = MemberDao.getInstance().checkID(id);
		req.setAttribute("id", id);
		req.setAttribute("result", result);
		req.getRequestDispatcher("login/idcheck.jsp").forward(req, resp);
		
	}

	
}
