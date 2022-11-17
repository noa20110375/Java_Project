package com.file;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController2
 */
@WebServlet("/file/upload.do")
public class FileController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("utf-8");
	//실질적으로 저장되는 폴더
	String savePath = "upload";//
	String encType ="utf-8";
	int uploadFileSizeLimit = 5*1024*1024;//최대 5mb 제한
	ServletContext context = getServletContext();
	String uploadFilePath = context.getRealPath(savePath);
	System.out.println("서버상의 실제 디렉토리:" +uploadFilePath );
	MultipartRequest multi = new MultipartRequest(
			request,// request 객체  
			uploadFilePath,//서버 상의 실제 디렉토리
			
			uploadFileSizeLimit,//최대업로드 파일크기
			
			encType,//인코딩
			
			new DefaultFileRenamePolicy());//동일 이름 존재할 때 새 이름 부여
	
	String fileName = multi.getFilesystemName("uploadFile");
	if(fileName == null)fileName ="";
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
	String image = multi.getParameter("image");
	
	FileDTO file = new FileDTO(name, title, image);
	FileDAO dao =  FileDAO.getInstnace();
	
	dao.fileInsert(file);
	}

}
