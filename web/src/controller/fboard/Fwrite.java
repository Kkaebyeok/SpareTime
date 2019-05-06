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

@WebServlet("/fwrite")
public class Fwrite extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("fboard/fwrite.jsp").forward(req, resp);
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
		String origin = multi.getOriginalFileName("pic");
		
		/*System.out.println("업로드된 이름 : " + fileName);
		System.out.println("원본 파일 이름 : " + origin);
		System.out.println("title1 : " + req.getParameter("title"));
		System.out.println("title2 : " + multi.getParameter("title"));*/
		FboardVo fboard = new FboardVo();
		fboard.setTitle(title);
		fboard.setContent(content);
		fboard.setWriter(writer);
		fboard.setPic(fileName);
		new FboardDao().write(fboard);
		resp.sendRedirect("flist");
	}
	
	
}
