package servlet.controller.classess;
//SERVELTS [CONTROLLER] WHICH CONTROLS THE REQUEST AND RESPONSE OF THE HTML PAGE

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.classes.RegisterJavaBean;
import jdbc.dao.classes.MainDAO;

/**
* Servlet implementation class Register
*/
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  public Register() {
      super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gender=request.getParameter("gender");//parameter name should be same as name given in the name attribute in the html file
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String year=request.getParameter("year");
		String garName=request.getParameter("garName");
		String garPhno=request.getParameter("garPhno");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String accountNo=request.getParameter("accountNo");
		String pin=request.getParameter("pin");
		
		RegisterJavaBean obj=new RegisterJavaBean(gender, firstName, lastName, month, day, year, garName, garPhno, email, address, city, state, country, accountNo, pin);  //CREATING A OBJECT OF BEAN CLASS
		//obj created of RegisterJavaBean is passed to the method insertingData and the constructor initializes the values and the same obj is used by the method body to get the values from javaBeanClass and store in the Database
		MainDAO call=new MainDAO();  //CREATING THE OBJECT OF DAO OR JDBC CODE CLASS
		
		String result=call.insertingData(obj);  //return whether the data is stored succesfully or any error is formed
		
		if(result.equals("success"))
		{
			succ(request,response);
		}
		else
		{
			err(request,response);
		}
		
		
	}

	private void err(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("detailErr.jsp");
		rd.forward(request, response);
		
	}
	private void succ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("detailSucc.jsp");
		rd.forward(request, response);
	}

}

