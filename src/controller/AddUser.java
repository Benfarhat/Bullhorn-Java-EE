package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;
import service.DbUser;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userMotto = request.getParameter("userMotto");
		
		String nextURL = "/error.jsp";
		
		Bhuser user = DbUser.getUserByEmail(userEmail);
		if(user == null) {
			user = new Bhuser();
			user.setUsername(userName);
			user.setUseremail(userEmail);
			user.setMotto(userMotto);
			user.setUserpassword(userPassword);
			
			Date joindate = Calendar.getInstance().getTime();
			user.setJoindate(joindate);
			
			DbUser.insert(user);
			nextURL = "/home.jsp";
		} else {
			String message = "This account already exists";
			request.setAttribute("message", message);
			nextURL = "/login.jsp";
		}
		
		session.setAttribute("user", user);
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
