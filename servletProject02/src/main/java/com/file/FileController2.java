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
	//���������� ����Ǵ� ����
	String savePath = "upload";//
	String encType ="utf-8";
	int uploadFileSizeLimit = 5*1024*1024;//�ִ� 5mb ����
	ServletContext context = getServletContext();
	String uploadFilePath = context.getRealPath(savePath);
	System.out.println("�������� ���� ���丮:" +uploadFilePath );
	MultipartRequest multi = new MultipartRequest(
			request,// request ��ü  
			uploadFilePath,//���� ���� ���� ���丮
			
			uploadFileSizeLimit,//�ִ���ε� ����ũ��
			
			encType,//���ڵ�
			
			new DefaultFileRenamePolicy());//���� �̸� ������ �� �� �̸� �ο�
	
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
