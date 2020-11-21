package ua.uz.alex.contloller;

import org.apache.log4j.Logger;
import ua.uz.alex.domain.User;
import ua.uz.alex.service.UserService;
import ua.uz.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();
    private static Logger LOGGER = Logger.getLogger(LoginController.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        User user = userService.readByString(email);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session= request.getSession(true);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("id", user.getId());
            session.setAttribute("role", user.getRole());
            session.setAttribute("fullName", user.getFirstName()
                    + " " +  user.getLastName());

          //  UserLogin userLogin = new UserLogin(user.getEmail(),"cabinet.jsp");
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Login success");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Login failed");
        }
    }
}
