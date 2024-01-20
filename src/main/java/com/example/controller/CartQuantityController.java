package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.CusPro;
import com.example.repository.ShopMyBatisDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/quantity")
public class CartQuantityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int order_number=Integer.parseInt(req.getParameter("order_number"));
        int quantity=Integer.parseInt(req.getParameter("quantity"));
        CusPro dto=new CusPro();
        dto.setOrder_number(order_number);
        dto.setQuantity(quantity);

        ShopMyBatisDAO dao=new ShopMyBatisDAO();
        int cnt=dao.updateQuantity(dto);
        // client --> ajax 요청 ---> 응답 ---> ajax 응답(success)
        PrintWriter out=resp.getWriter();
        out.println(cnt);

    }
}
