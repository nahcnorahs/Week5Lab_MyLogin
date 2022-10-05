
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

/**
 *
 * @author Sharon
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logOut = request.getParameter("logOut");
        String logIn = (String) session.getAttribute("logIn");
        
        if (logOut != null){
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            
        } else if (logIn != null){
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountService user = new AccountService();
        
       if (username == null || username.equals("") || password == null || password.equals("")){
           request.setAttribute("message", "Invalid. Please enter in a username and password");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
       } else if (user != null){
           request.setAttribute("message", "Invalid");
           response.sendRedirect("home");
           
       } else {
           request.setAttribute("username", username);
           request.setAttribute("password", password);
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
       }
    }


}
