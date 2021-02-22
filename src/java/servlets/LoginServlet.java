package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 631503
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String user = (String) session.getAttribute("user");

        if (user != null && logout == null) {
            response.sendRedirect("home");
        } else if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have been successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("password", password);

        AccountService account = new AccountService();
        User user = account.login(username, password);

        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "Enter username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

        if (user != null) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("home");
        } else {
            request.setAttribute("message", "Incorrect username or password.");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

}
