package com.example.controller;
// Servlet의 기본 골격
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/")
public class TemplateController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         // forward
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(req, resp);
    }
}
