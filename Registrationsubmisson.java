package registrationsubmisson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrationsubmisson
 */
@WebServlet("/Registrationsubmisson")
public class Registrationsubmisson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
		System.out.println("connection bulid");
		String n=request.getParameter("uname");
		String p=request.getParameter("uphone");
		String e=request.getParameter("uemail");
		String b=request.getParameter("ubirth");
		String ad=request.getParameter("uadd");
		PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?,?,?)");
		ps.setString(1, n);
		ps.setString(2, p);
		ps.setString(3, e);  
		ps.setString(4, b);
		ps.setString(5, ad);
		ps.executeUpdate();
		out.println("<html><body bgcolor=green>");
		out.println("<h1>Your form submited<h1><br>");
		out.println(n+"</body></html>");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			out.print("sorry! try again");
			e.printStackTrace();
		}
		}

}
