package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

@WebServlet("/coffees/add")
public class CoffeeAddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		int price = Integer.parseInt(req.getParameter("coffeePrice"));
		
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		coffeeDAO.add(new Coffee(name, size, price));
		resp.sendRedirect("/step04mvc2practice/index.html");
	}

}
