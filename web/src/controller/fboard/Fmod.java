package controller.fboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import controller.file.FileUpload;
import dao.fboard.FboardDao;
import vo.fboard.FboardVo;

@WebServlet("/fmod")
public class Fmod extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("no") != null) {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			FboardVo board = new FboardDao().read(boardNo);
			req.setAttribute("fboard", board);
			req.getRequestDispatcher("fboard/fmod.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String path = getServletContext().getRealPath("upload");
		MultipartRequest multi = FileUpload.getInstance().getMulti(req, path);
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String fileName =  multi.getFilesystemName("pic");
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		FboardVo fboard = new FboardVo();
		fboard.setBoardNo(boardNo);
		fboard.setTitle(title);
		fboard.setContent(content);
		fboard.setWriter(writer);
		fboard.setPic(fileName);
		new FboardDao().mod(fboard);
		
		resp.sendRedirect("flist");
	}

	
}
