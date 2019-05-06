package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemberDao;
import vo.member.MemberVo;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String url = "login/login.jsp";
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		MemberDao dao = MemberDao.getInstance();
		HttpSession session = req.getSession();
		int result = dao.login(id, pw);
		if (result==1) {
			MemberVo vo = dao.getMember(id);
			session.setAttribute("loginUser", vo);
			req.setAttribute("nik", req.getParameter("nik"));
			req.setAttribute("id", req.getParameter("id"));
			resp.sendRedirect("index");
		}else if (result== 0) {
			req.getRequestDispatcher(url).forward(req, resp);
		}else if (result== 2) {
			req.getRequestDispatcher(url).forward(req, resp);
		} else {
			req.getSession(true).invalidate();
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}
}
