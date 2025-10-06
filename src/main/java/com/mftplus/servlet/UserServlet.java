package com.mftplus.servlet;

import com.mftplus.model.entity.User;
import com.mftplus.model.service.Service;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Inject private Service<User> userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
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
