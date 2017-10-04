package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginSer
 */
@WebServlet("/loginSer")
public class loginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginSer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    java.util.Enumeration e = request.getParameterNames();
	    
	    out.println("<TABLE BORDER=1 COLOR=red>");
	    
	    while(e.hasMoreElements())
	    {
	    	String fieldname = (String)e.nextElement();
	    	String value = request.getParameter(fieldname);
	    	
	    	if(value.length()!=0)
	    	{
	    		out.println("<TR><TH>" + fieldname + "</TH><TD>" + value + "</TD></TR>");
	    	}
	    	else
	    	{
	    		out.println("<TR><TH>" + fieldname + "</TH> <TD>Null</TD> </TR>");
	    	}
	    }
	    out.print("<TABLE>");
	    out.close();
	}

}
