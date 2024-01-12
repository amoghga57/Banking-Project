package servlet.controller.classess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.dao.classes.MainDAO;

@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteAccount() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainDAO.deleteAccount();
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
