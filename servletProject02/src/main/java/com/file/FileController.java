package com.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController
 */
@WebServlet("/file/upload.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	String savePath = "upload";// 저장될 파일의 위치
	int uploadFileSizeLimit = 5*1024*1024;//최대 5mb 로 제한
	String encType ="utf-8";
	ServletContext context = getServletContext();
	//RealPath 가 실제로 동작 되어지는 것.?
	String uploadFilePath = context.getRealPath(savePath);
	System.out.println("서버상의 실제 디렉토리:" +uploadFilePath );
	MultipartRequest multi = new MultipartRequest(
			request,// request 객체  
			uploadFilePath,//서버 상의 실제 디렉토리
			
			uploadFileSizeLimit,//최대업로드 파일크기
			
			encType,//인코딩
			
			new DefaultFileRenamePolicy());//동일 이름 존재할 때 새 이름 부여
			//업로드한 파일 이름
String fileName =	multi.getFilesystemName("uploadFile");
System.out.println(fileName);

if(fileName==null) {
	System.out.println("파일업로드 안함");
}else {
	response.setContentType("text/html;charset= utf-8");
	PrintWriter out = response.getWriter();
out.println("글쓴이:" + multi.getParameter("name")+ "<br/>");
out.println("제목:" + multi.getParameter("title")+ "<br/>");	
out.println("파일명:" +fileName+ "<br/>");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
