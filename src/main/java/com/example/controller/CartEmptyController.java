package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.Customer;
import com.example.repository.ShopMyBatisDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
@WebServlet("/empty")
public class CartEmptyController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String customer_id=req.getParameter("customer_id");
        int totalAmount=Integer.parseInt(req.getParameter("totalAmount"));
        ShopMyBatisDAO dao=new ShopMyBatisDAO();
        // 10% 적립금 누적
        int point=(int)(totalAmount*0.1);
        Customer cus=new Customer();
        cus.setCustomer_id(customer_id);
        cus.setReserves(point);
        dao.pointSave(cus);

        int cnt=dao.cartEmpty(customer_id);
        PrintWriter out=resp.getWriter();
        out.println(cnt);
    }
}
