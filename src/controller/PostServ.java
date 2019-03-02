package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhpost;
import model.Bhuser;
import service.DbPost;

/**
 * Servlet implementation class PostServ
 */
@WebServlet("/PostServ")
public class PostServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PostServ.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServ() {
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
		
		String posttext = request.getParameter("posttext");
		String nextURL = "/error.jsp";
		
		System.out.println(posttext);
		LOG.log(Level.INFO, posttext);
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") == null) {
		    
		    System.out.println("Invalid user, redirect to login");
			nextURL = "/login.jsp";
			session.invalidate();
		} else {
			Bhuser bhuser = (Bhuser) session.getAttribute("user");
			
			// Insert the post
			
			Bhpost bhPost = new Bhpost();
			bhPost.setBhuser(bhuser);
			Date postdate = Calendar.getInstance().getTime();
			bhPost.setPostdate(postdate);
			bhPost.setPosttext(posttext);
			DbPost.insert(bhPost);
			System.out.println("New post created!");
			
			nextURL = "/Newsfeed";
			
		}
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
