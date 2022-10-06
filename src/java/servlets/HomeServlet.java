
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sharon
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = (String)session.getAttribute("username");
        
        if (username!= null){
            //request.setAttribute("username",username);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("home");
            return;
            
        }
        
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
