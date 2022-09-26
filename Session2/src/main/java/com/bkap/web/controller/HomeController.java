package com.bkap.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({ "/HomeController", "/home", "/trang-chu" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("date", "14/09/2022");
		
		response.addCookie(cookie);
		
		// Lấy cookie
		request.getCookies();
		
		// Lấy session
		HttpSession session = request.getSession();
		Object ssUserName = session.getAttribute("user");
		if (ssUserName == null) {
			response.sendRedirect("login");
		} else {
			request.getRequestDispatcher("views/home/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
