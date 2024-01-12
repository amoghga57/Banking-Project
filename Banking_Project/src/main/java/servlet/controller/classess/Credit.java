package servlet.controller.classess;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.classes.MainDAO;
@WebServlet("/Credit")
public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Credit() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String creditAmt=request.getParameter("creditAmt");
		double creditAmtInt=Double.parseDouble(creditAmt);
		boolean res=MainDAO.creditMoney(creditAmtInt);
		if(res)
		{
			added(request,response);
		}
	}
	private void added(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("amtDeposited.jsp");
		rd.forward(request, response);
	}

}
