package jdbc.dao.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.classes.RegisterJavaBean;

/**
 * class for login jdbc code
 */
public class MainDAO {
	static String url="jdbc:mysql://localhost:3306/banking_project";
	static String username="root";
	static String password="doreamonobitag57";
	public static String resaccNo="";
	public static String resusername="";
	public static String resemail="";
	public static String pinNoChange="";
//------------------------------------------------------------------------------------	
	public static  Connection connection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
//-------------------*****
	/**
	 * Method to check the email and pin are present in the database or not.
	 * @param email
	 * @param pin
	 * @return If the data ispresent in the database ,the it is redirected to user main page else to the same page with error notification
	 */
	public static String validation(String email,String pin)
	{
		String show="samePage";
		PreparedStatement pst=null;
		ResultSet res=null;
		String query="select * from customer_info where EMAIL=? and PIN=?";
		Connection con=connection();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pin);
			res=pst.executeQuery();
			if(res.next())
			{
				if(email.equals(res.getString(9)) && pin.equals(res.getString(15)))
				{
					show="nextPage";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con, pst);
		}
		return show;
	}
//-------------------
	/**
	 * Method to enter the details of the customer ,which is read from the form and Register.java servlet calls the function
	 * @param obj of the details created
	 * @return message
	 */
	public String insertingData(RegisterJavaBean obj) 
	{
		String res="success";	
		PreparedStatement p=null;
		Connection con=connection();
		String sqlStatement="insert into customer_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {																//CREATE A STATEMENT / PLATFORM
			p=con.prepareStatement(sqlStatement);							//EXECUTE THE QUERY
			p.setString(1, obj.getGender());
 			p.setString(2, obj.getFirst_name());
			p.setString(3, obj.getLast_name());
			p.setString(4, obj.getDob_month());
			p.setString(5, obj.getDob_day());
			p.setString(6, obj.getDob_year());
			p.setString(7, obj.getGardian_name());
			p.setString(8, obj.getG_phno());
			p.setString(9, obj.getEmail());
			p.setString(10, obj.getAddress());
			p.setString(11, obj.getCity());
			p.setString(12, obj.getState());
			p.setString(13, obj.getCountry());
			p.setString(14, obj.getAccount_no());
			p.setString(15, obj.getPin());
			p.setString(16, "0");
			p.setString(17, "0");
			p.setString(18, "5000");
			p.execute();	
		} catch (SQLException e) {
			res="error";
			e.printStackTrace();
		}		
		finally {
			closeConnection(con, p);
		}
		return res;
	}
//-------------------
	/**
	 * Method is used to add amount to the D.B and method is called from the Credit.java servlet
	 * @param amt
	 * @return message
	 */
	public static boolean creditMoney(double amt)
	{
		boolean flag=true;
		Connection con=connection();
		PreparedStatement p1=null,p2=null,p3=null;
		double add=0, addres=0;
		String mailId=resemail;
		String sqlStatment1="select * from customer_info where EMAIL=?";
		String sqlStatment2="update customer_info set balance=? where email=? ";
		String sqlStatment3="insert into transaction_history values(?,?,0,NOW())";
		try {
			p1=con.prepareStatement(sqlStatment1);
			p3=con.prepareStatement(sqlStatment3);
			p1.setString(1, mailId);
			int pinNoChange=Integer.parseInt(MainDAO.pinNoChange);
			p3.setInt(1,pinNoChange);
			p3.setDouble(2,amt);
			ResultSet rs1=p1.executeQuery();
			if(rs1.next())
			{
				add=rs1.getInt(18);//balance amount
			}
			addres=amt+add;//balance amt plus input amt
			p2=con.prepareStatement(sqlStatment2);
			p2.setDouble(1, addres);
			p2.setString(2, mailId);
			p2.executeUpdate();
			p3.executeUpdate();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			closeConnection(con, p2);
		}
		return flag;
	}
//-------------------
	/**
	 * Method is used to remove amount from the D.B and method is called from the Debit.java servlet
	 * @param amt
	 * @return 3 possiblity,
	 * if the money is greater than the deposited ,then deposit some money
	 * if the money is empty ,and try to debit, it will return to deposit
	 * else deposite
	 */
	public static String debitMoney(double amt)
	{
		String op="";
		Connection con=connection();
		PreparedStatement p1=null,p2=null,p3=null;
		double add=0, addres=0;
		String mailId=resemail;
		String sqlStatment1="select * from customer_info where EMAIL=?";
		String sqlStatment2="update customer_info set balance=? where email=? ";
		String sqlStatment3="insert into transaction_history values(?,0,?,NOW());";
		try {
			p1=con.prepareStatement(sqlStatment1);
			p1.setString(1, mailId);
			
			ResultSet rs1=p1.executeQuery();
			if(rs1.next())
			{
				add=rs1.getInt(18);//balance amount
			}

			if(add<=0)
			{
				op="NoBalanceAtAll";
			}
			else if(add<amt)
			{
				op="AmtIsHigh";
			}
			else if(add>=amt)
			{
				op="Done";
				addres=add-amt;
				p2=con.prepareStatement(sqlStatment2);
				p2.setDouble(1, addres);
				p2.setString(2, mailId);
				p3=con.prepareStatement(sqlStatment3);
				int pinNoChange=Integer.parseInt(MainDAO.pinNoChange);
				p3.setInt(1,pinNoChange);
				p3.setDouble(2,amt);
				p2.executeUpdate();
				p3.executeUpdate();
			}
		} catch (SQLException e) {
			op="false";
			e.printStackTrace();
		}
		finally {
			closeConnection(con, p2);
		}
		return op;
		
	}
//-------------------
	/**
	 * Method is used to show amount from D.B and method is called directly from the JSP
	 * @return
	 */
	public static double remBalance()
	{
		double value=0;
		Connection con=connection();
		PreparedStatement p=null;
		ResultSet rs=null;
		String mailId=resemail;
		String sqlStatement="select * from customer_info where EMAIL=?";
		try {
			p=con.prepareStatement(sqlStatement);
			p.setString(1, mailId);
			rs=p.executeQuery();
			rs.next();
			value=rs.getDouble(18);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con, p);
		}
		return value;
	}
//-------------------
	/**
	 * Used to temporarily store the pin in a variable static.[throughout the login],onces exited pin is gone
	 * Used widley by the JSP pages for dynamic display of details by calling respectievly methods
	 * @param pin
	 */
	public static void settingThePinConstant(String pin)
	{
		pinNoChange=pin;
	}
//-------------------
	/**
	 * Gives the account number of the user and method is called directly from the JSP page 
	 * @return account number of the customer
	 */
	public static String accNo()
	{
		Connection con=connection();
		PreparedStatement p=null;
		ResultSet rs=null;
		String sqlStatement="select * from customer_info where PIN=?";
		try {
			p=con.prepareStatement(sqlStatement);
			p.setString(1, pinNoChange);
			rs=p.executeQuery();
			rs.next();
			resaccNo=rs.getString(14);
		} catch (SQLException e) {
			resaccNo="Not found";
			e.printStackTrace();
		}
		finally {
			closeConnection(con, p);
		}
		return resaccNo;
	}
//-------------------
	/**
	 * Gives the username number of the user and method is called directly from the JSP page 
	 * @return username of the customer
	 */
	public static String username()
	{
		Connection con=connection();
		PreparedStatement p=null;
		ResultSet rs=null;
		String sqlStatement="select * from customer_info where PIN=?";
		try {
			p=con.prepareStatement(sqlStatement);
			p.setString(1, pinNoChange);
			rs=p.executeQuery();
			rs.next();
			resusername=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
		} catch (SQLException e) {
			resusername="Not found";
		}
		finally {
			closeConnection(con, p);
		}
		return resusername;
	}
//-------------------
	/**
	 * Gives the account number of the user and method is called directly from the JSP page 
	 * @return email of the customer
	 */
	public static String email()
	{
		Connection con=connection();
		PreparedStatement p=null;
		ResultSet rs=null;
		String sqlStatement="select * from customer_info where PIN=?";
		try {
			p=con.prepareStatement(sqlStatement);
			p.setString(1, pinNoChange);
			rs=p.executeQuery();
			rs.next();
			resemail=rs.getString(9);
		} catch (SQLException e) {
			resemail="Not found";
		}
		finally {
			closeConnection(con, p);
		}
		return resemail;
	}
//-------------------
	/**
	 * This method is used process the transaction of the customer ,by using the pin
	 * the debit or credit amount value will be taken and order in the query and displayed in the rs reference
	 * @return reference of the ResultSet to display all the transaction
	 */
	public static ResultSet history()
	{
		Connection con=connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sqlStatement="select  * from transaction_history where pin=? order by time desc";
		try {
			ps=con.prepareStatement(sqlStatement);
			int pinNoChange=Integer.parseInt(MainDAO.pinNoChange);
			ps.setInt(1,pinNoChange);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
//-------------------
	/**
	 * Uses to take first and last character of the name for the logo
	 * @return
	 */
	public static String firstLastName()
	{
		String res="",s1="",s2="";
		Connection con=connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sqlStatement="select * from customer_info where pin=?";
		try {
			ps=con.prepareStatement(sqlStatement);
			ps.setString(1, pinNoChange);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s1=rs.getString(2);
				s2=rs.getString(3);
			}
			res=s1.toUpperCase().charAt(0)+"."+s2.toUpperCase().charAt(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
//-------------------
	/**
	 * Method used to delete the account permanetly from the D.B
	 */
	public static void deleteAccount()
	{
		Connection con=connection();
		PreparedStatement ps1=null,ps2=null;
		String sqlStatement1="delete from customer_info where pin=?";
		String sqlStatement2="delete from transaction_history where pin=?";
		try {
			ps1=con.prepareStatement(sqlStatement1);
			ps1.setString(1, pinNoChange);
			ps1.executeUpdate();
			ps2=con.prepareStatement(sqlStatement2);
			ps2.setString(1, pinNoChange);
			ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//-------------------*****
	
	public static void closeConnection(Connection con,PreparedStatement p)
	{
			if(p!=null)
			{
				try {
					p.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
//------------------------------------------------------------------------------------	
//	public static void main(String[] args) {
//		System.out.println(debitMoney(1000));
//	}
	
	
	
	

}
