package com.itqf.controller;

import com.itqf.entity.Cart;
import com.itqf.entity.User;
import com.itqf.service.CartService;
import com.itqf.service.impl.CartServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cart")
public class CartController extends BaseServlet {

    public String addCart(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");

        if (user == null) {
            session.setAttribute("msg","添加购物车必须下先登录！");
            return Constants.REDIRECT + "/login.jsp";
        }

        String pid = request.getParameter("pid");
        CartService cartService = new CartServiceImpl();
        cartService.addCart(pid,user.getUid());

        return Constants.FORWARD + "/cartSuccess.jsp";
    }

    public String showCart(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");

        if (user == null) {
            session.setAttribute("msg","查看购物车必须下先登录！");
            return Constants.REDIRECT + "/login.jsp";
        }

        CartService cartService = new CartServiceImpl();
        List<Cart> carts = cartService.findCartByUid(user.getUid());
        request.setAttribute("carts", carts);
        return Constants.FORWARD + "/cart.jsp";
    }
}
