package com.bkap.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkap.web.entity.Category;
import com.bkap.web.repository.CategoryRepository;

/**
 * Servlet implementation class CategoriesController
 */
@WebServlet({ "/CategoriesController", "/categories", "/danh-muc" })
public class CategoriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryRepository categoryRepository;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesController() {
    	categoryRepository = new CategoryRepository();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		
		String action = request.getParameter("action");
		
		
		if (action == null || action.equals("index")) {
			List<Category> data = categoryRepository.getAll();
			request.setAttribute("list", data);
			view = "views/categories/index.jsp";
		} else if (action.equals("add")) {
			view = "views/categories/insert.jsp";
		} else if (action.equals("edit")) {
			String id = request.getParameter("id");
			request.setAttribute("cat", categoryRepository.findId(Integer.parseInt(id)));
			view = "views/categories/update.jsp";
		} else if (action.equals("delete")) {
			String id = request.getParameter("id");
			categoryRepository.remove(Integer.parseInt(id));
			List<Category> data = categoryRepository.getAll();
			request.setAttribute("list", data);
			view = "views/categories/index.jsp";
		} else {
			view = "views/not-found.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int counts = Integer.parseInt(request.getParameter("counts"));
		
		if (action != null && action.equals("add")) {
			categoryRepository.add(new Category(id, name, counts));
		}
		
		if (action != null && action.equals("edit")) {
			categoryRepository.edit(new Category(id, name, counts));
		}
		response.sendRedirect("danh-muc");
	}

}
