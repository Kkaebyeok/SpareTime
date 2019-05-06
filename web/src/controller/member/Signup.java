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

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("member/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String nik = req.getParameter("nik");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		int admin = Integer.parseInt(req.getParameter("admin"));
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setNik(nik);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setAdmin(admin);
		
		int result = MemberDao.getInstance().signup(vo);
		HttpSession session = req.getSession();
		
		session.setAttribute("id", vo.getId());
		req.getRequestDispatcher("login/login.jsp").forward(req, resp);
	}
	
}
