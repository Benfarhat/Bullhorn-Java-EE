package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;
import service.DbUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");
		String action = request.getParameter("action");
		// String remember = request.getParameter("remember");
		
		String nextURL = "/error.jsp";
		
		HttpSession session = request.getSession( true );
		
		if (action.contentEquals("logout")) {
			session.invalidate();
			nextURL = "/login.jsp";
		} else {
			if (DbUser.isValideUser(useremail, userpassword)) {
				Bhuser user = DbUser.getUserByEmail(useremail);
				
				session.setAttribute("user", user);
				int gravatarImageWidth = 30;
				String gravatarURL = DbUser.getGravatarURL(useremail, gravatarImageWidth);
				
				session.setAttribute("gravatarURL", gravatarURL);

				nextURL = "/home.jsp";
			} else {
				nextURL = "/login.jsp";
			}
		}
		
		// redirect to next page
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);

	}

}
