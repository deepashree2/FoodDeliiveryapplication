package com.foodDeliveryApp.servletss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDeliveryApp.dao.UserDAO;
import com.foodDeliveryApp.daoImpls.UserDAOImpls;
import com.foodDeliveryApp.models.User;
import org.mindrot.jbcrypt.BCrypt; // Import BCrypt class

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpls();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String role = "Customer"; // Set the role as needed

        // Hash the password before storing it in the database
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(hashedPassword);
        newUser.setEmail(email);
        newUser.setAddress(address);
        newUser.setRole(role);

        userDAO.addUser(newUser);

        // Redirect to home after successful signup
        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests if needed (not shown in the original code)
    }
}
