package com.mftplus.servlet;

import com.mftplus.model.entity.User;
import com.mftplus.model.service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Service<User> userService = new Service<>(User.class);
            req.getSession().setAttribute("users", userService.findAll());
            System.out.println("Info : FindAll Persons");
        }
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Service<User> userService = new Service<>(User.class);
            User user =
                    User
                            .builder()
                            .firstName(req.getParameter("firstName"))
                            .familyName(req.getParameter("familyName"))
                            .build();
            userService.save(user);
            System.out.println("Info : Save Person");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        id,name,family
        try {
            Service<User> userService = new Service<>(User.class);
            User user =
                    User
                            .builder()
                            .firstName(req.getParameter("firstName"))
                            .familyName(req.getParameter("familyName"))
                            .build();
            userService.save(user);
            System.out.println("Info : Save Person");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        id
    }
}
