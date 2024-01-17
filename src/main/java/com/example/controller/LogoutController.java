package com.example.controller;
// Servlet의 기본 골격

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session=req.getSession();
            session.invalidate();
            resp.sendRedirect("/shopping/list");
    }
}
