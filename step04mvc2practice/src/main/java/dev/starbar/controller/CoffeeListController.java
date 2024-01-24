package dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

@WebServlet("/coffees")
public class CoffeeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		List<Coffee> coffees = coffeeDAO.findAll();
		final String url = "/WEB-INF/coffeeList.jsp";
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		
		req.setAttribute("list", coffees);
		dispatcher.forward(req, resp);
		
	}

}
