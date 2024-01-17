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
@WebServlet("/cartAdd")
public class CartAddController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String customer_id=req.getParameter("customer_id");
        int product_number=Integer.parseInt(req.getParameter("product_number"));
        CusPro dto=new CusPro();
        dto.setCustomer_id(customer_id);
        dto.setProduct_number(product_number);

        ShopMyBatisDAO dao=new ShopMyBatisDAO();

        int cnt=dao.cartAdd(dto);
        //resp.setContentType("text/json");
        PrintWriter out=resp.getWriter();
        out.println(cnt);
    }
}
