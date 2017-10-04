package MSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MSBServlet
 */
@WebServlet("/MSBServlet")
public class MSBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
		response.setContentType("text/html");		
		ServletOutputStream sos = response.getOutputStream();
		
		double radius = Double.parseDouble(request.getParameter("rad"));
		
		String s1 = request.getParameter("a1");
		String s2 = request.getParameter("p1");
		
		sos.println("<h3>");
		
		if(s1!=null)
		{
			sos.println("You clicked "+s1+" button");
			sos.println("Area is "+ Math.PI*radius*radius+"</h2>");
			
		}
		else if(s2!=null)
		{
			sos.println("You clicked "+s2+" button");
			sos.println("<h2>Perimeter is "+ 2*Math.PI*radius+"</h2>");
		}
		
		sos.println("</h3>");
		sos.close();
		
		
	}

}
