package com.itqf.controller;

import com.itqf.entity.PageBean;
import com.itqf.entity.Product;
import com.itqf.service.ProductService;
import com.itqf.service.impl.ProductServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/product")
public class ProductController extends BaseServlet {
    public String showDetail(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        String pid = request.getParameter("pid");

        ProductService productService = new ProductServiceImpl();

        Product product = productService.findProductById(pid);

        request.setAttribute("product",product);

        return Constants.FORWARD + "/goodsDetail.jsp";
    }

    public String show(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        String tid = request.getParameter("tid");
        String currentPage = request.getParameter("currentPage");
        int page = 1;
        if (currentPage != null) {
            page = Integer.parseInt(currentPage);
        }

        int pageSize = 6;

        ProductService service = new ProductServiceImpl();
        PageBean<Product> pageBean = service.findProductByPage(tid,page,pageSize);

        request.setAttribute("pageBean",pageBean);

        return Constants.FORWARD +"/goodsList.jsp";
    }
}
