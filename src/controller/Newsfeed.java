package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhpost;
import service.DbPost;

/**
 * Servlet implementation class Newsfeed
 */
@WebServlet("/Newsfeed")
public class Newsfeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newsfeed() {
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
		
		long filterByUserID = 0;
		String searchtext = "";
		
		String nextURL = "/error.jsp";
		
		HttpSession session = request.getSession( true );
		if (session.getAttribute("user") == null) {
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
			
			return;
		}
		
		List<Bhpost> posts = null;
		if (request.getParameter("userid") != null && !request.getParameter("userid").isEmpty() ) {
			filterByUserID = Integer.parseInt(request.getParameter("userid"));
			posts = DbPost.postOfUser(filterByUserID);
		} else if (request.getParameter("searchtext") != null && request.getParameter("searchtext").isEmpty()) {
			searchtext = request.getParameter("searchtext").toString();
			posts = DbPost.searchPosts(searchtext);
		} else {
			posts = DbPost.bhPost();
		}
		
		request.setAttribute("posts", posts);
		
		nextURL = "/newsfeed.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
