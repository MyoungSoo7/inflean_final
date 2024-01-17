package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.CusProProduct;
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
@WebServlet("/cartList")
public class CartListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String customer_id=req.getParameter("customer_id");

        ShopMyBatisDAO dao=new ShopMyBatisDAO();
        List<CusProProduct> list=dao.cartList(customer_id);
        req.setAttribute("list", list);
        // total amount 값구하기
        if(list.size()!=0) {
            int totalAmount = dao.totalAmount(customer_id);
            req.setAttribute("totalAmount", totalAmount);
        }
         // forward
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/cartList.jsp");
        rd.forward(req, resp);
    }
}
