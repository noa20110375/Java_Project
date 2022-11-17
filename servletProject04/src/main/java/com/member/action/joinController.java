package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
import com.util.SHA256;

/**
 * Servlet implementation class joinController
 */
@WebServlet("/member/join")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SMemberDTO  mb = new SMemberDTO();
		mb.setName(request.getParameter("name"));
		mb.setUserid(request.getParameter("userid"));
		//mb.setPwd(request.getParameter("pwd"));
		mb.setEmail(request.getParameter("email"));
		mb.setPhone(request.getParameter("phone"));
		mb.setAdmin(Integer.parseInt(request.getParameter("admin")));

		String userid = request.getParameter("userid");
		String encPwd =SHA256.getEncrypt(request.getParameter("pwd"),userid);
		mb.setPwd(encPwd);
		
		
		
		SMemberDAO dao = SMemberDAOImpl.getInstnace();
		dao.memberJoin(mb);
		response.sendRedirect("login");
	
	
	
	}

}
