package servlet.controller.classess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.classes.MainDAO;


@WebServlet("/Debit")
public class Debit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Debit() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String debitAmt=request.getParameter("debitAmt");
		double debitAmtInt=Double.parseDouble(debitAmt);
		String res=MainDAO.debitMoney(debitAmtInt);
		if(res.equals("NoBalanceAtAll"))
		{
			NoBalanceAtAll(request,response);
		}
		else if(res.equals("AmtIsHigh"))
		{
			AmtIsHigh(request,response);
		}
		else
		{
			success(request,response);
		}
	}
	private void success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("amtWithdrawed.jsp");
		rd.forward(request, response);
	}


	private void AmtIsHigh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("debitAmtIsMore.jsp");
		rd.forward(request, response);
	}


	private void NoBalanceAtAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("debitZeroAmt.jsp");
		rd.forward(request, response);
		
	}
	

}
