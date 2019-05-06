package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;

@WebServlet("/delect")
public class Delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id = req.getParameter("id");
		 String pw = req.getParameter("pw");
		 
		 boolean result = MemberDao.getInstance().isMember(id);
		 
		 
		 if (result == true) {
			 MemberDao.getInstance().deleteMember(id);
				req.getSession().invalidate();
				resp.sendRedirect("index");
		}else {
			resp.sendRedirect("info");
		}
	}
}
