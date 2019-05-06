package member.check;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemberDao;
import vo.member.MemberVo;

@WebServlet("/textlog")
public class TextLog extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.login(id, pw);
		req.setAttribute("id", id);
		req.setAttribute("result", result);
		req.getRequestDispatcher("login/textlog.jsp").forward(req, resp);
		
	}
}
