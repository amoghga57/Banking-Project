package servlet.controller.classess;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.classes.MainDAO;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Validation() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at:Wrong check it out ").append(request.getContextPath());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/**
		 * Storing the email and pin in particular string using request parameter from html page
		 */
		String email=request.getParameter("email");
		String pin=request.getParameter("pin");
		//Calling the validation method with class LoginDao.java
		String res=MainDAO.validation(email,pin);
		if(res.equals("nextPage"))
		{
			nextPage(request,response);
		}
		else
		{
			samePage(request,response);
		}
	}
	/**
	 * Login page to main page.Redirected to user home page
	 * @param request
	 * @param response
	 */
	private void samePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("indexError.jsp");
		rd.forward(request, response);
		
	}
	/**
	 * Login page to same page .Redirected to same page with error saying[invalid email or pin]
	 * @param request
	 * @param response
	 */
	private void nextPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("homePage.jsp");
		rd.forward(request, response);
		
	}

}
