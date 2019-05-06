package controller.file;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUpload {
	private static FileUpload instance = new FileUpload();
	private FileUpload() {}
	
	public static FileUpload getInstance() {
		return instance;
	}

	public MultipartRequest getMulti(HttpServletRequest request, String url) {
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, url, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multi;
	}
}
