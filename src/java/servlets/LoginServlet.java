
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author Sharon
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String logout = (String) request.getParameter("logout");
        
        if (logout != null){
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            //session = request.getSession();
            
        } else if (username != null){
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
        }
        //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
       
    }
     
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        AccountService user = new AccountService();
        
       if (username == null || username.equals("") || password == null || password.equals("")){
           request.setAttribute("message", "Invalid. Please enter in a username and password");
           getServletContext().getRequestDispatcher("/WEB-INF/login/jsp").forward(request,response);
           
       } else if (user != null){
           HttpSession session = request.getSession();
           session.setAttribute("username",username);
           response.sendRedirect("home");
           return;
           
       } else {
//           request.setAttribute("username", username);
//           request.setAttribute("password", password);
           request.setAttribute("message","Invalid Username and Password.");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
          
       }
       //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
     //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);


}
