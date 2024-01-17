package com.example.controller;
// Servlet의 기본 골격

import com.example.repository.ShopMyBatisDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/cancel")
public class CartCancelController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int order_number=Integer.parseInt(req.getParameter("order_number"));
        String customer_id=req.getParameter("customer_id");
        ShopMyBatisDAO dao=new ShopMyBatisDAO();
        int cnt=dao.cartCancel(order_number);
        resp.sendRedirect("/shopping/cartList?customer_id="+customer_id);
    }
}
