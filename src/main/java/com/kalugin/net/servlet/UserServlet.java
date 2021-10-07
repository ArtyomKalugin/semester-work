package com.kalugin.net.servlet;

import com.kalugin.net.service.impl.UserServiceImpl;
import com.kalugin.net.dto.UserDTO;
import com.kalugin.net.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    private static final List<UserDTO> USERS = Arrays.asList(new UserDTO("Tape", "Na Babkah"),
            new UserDTO("Artem", "Kalugin"));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
