package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;
import service.DbUser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession( true );
		String nextURL = "/error.jsp";
		long userid = 0;
		String action = "";
		Bhuser profileUser = null;
		Bhuser loggedInUser = null;
		if (session.getAttribute("user") == null){
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
			
			return;
		}
		
		try {
			userid = Long.parseLong(request.getParameter("userid"));
			action = request.getParameter("action");
			if ( request.getParameter("action").equals("updateprofile")) {
				long uid = Long.parseLong(request.getParameter("userid"));
				String userEmail = request.getParameter("useremail");
				String userMotto = request.getParameter("usermotto");
				Bhuser updateUser = DbUser.getUser(uid);
				updateUser.setMotto(userMotto);
				updateUser.setUseremail(userEmail);
				DbUser.update(updateUser);
			}
			
			profileUser = DbUser.getUser(userid);
			loggedInUser = (Bhuser) session.getAttribute("user");
			if(profileUser.getBhuserid() == loggedInUser.getBhuserid()) {
				session.setAttribute("editProfile", true);
			} else {
				session.setAttribute("editProfile", false);
			}
			
			int imgSize = 120;
			SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
			String joindate = sdf.format(profileUser.getJoindate());
			
			request.setAttribute("userid", profileUser.getBhuserid());
			request.setAttribute("userimage", DbUser.getGravatarURL(profileUser.getUseremail(), imgSize));
			request.setAttribute("username", profileUser.getUsername());
			request.setAttribute("useremail", profileUser.getUseremail());
			request.setAttribute("usermotto", profileUser.getMotto());
			request.setAttribute("userjoindate", joindate);
			
			nextURL = "/profile.jsp";			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
