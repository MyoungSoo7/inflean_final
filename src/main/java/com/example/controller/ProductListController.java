package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.Product;
import com.example.repository.ShopMyBatisDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/list")
public class ProductListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShopMyBatisDAO dao=new ShopMyBatisDAO();
        List<Product> list=dao.productList();
        req.setAttribute("list", list);
         // forward
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);
    }
}
