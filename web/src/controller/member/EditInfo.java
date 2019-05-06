package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import vo.member.MemberVo;

@WebServlet("/editinfo")
public class EditInfo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("vo", MemberDao.getInstance().getMember(req.getParameter("id")));
		req.getRequestDispatcher("member/editinfo.jsp").forward(req, resp);
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
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(nik);
		System.out.println(email);
		System.out.println(tel);
		System.out.println(admin);
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setNik(nik);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setAdmin(admin);
		System.out.println(vo+":: vo");
		MemberDao.getInstance().editMember(vo);
		
		resp.sendRedirect("info");
	}
	
}
