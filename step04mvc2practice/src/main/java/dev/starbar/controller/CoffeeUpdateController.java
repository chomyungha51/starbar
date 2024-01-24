package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;

@WebServlet("/coffees/update")
public class CoffeeUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("coffeeId"));
		String name= req.getParameter("coffeeName");
		String size= req.getParameter("coffeeSize");
		int price = Integer.parseInt(req.getParameter("coffeePrice"));
		
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		coffeeDAO.updateCoffee(id, name, size, price);
		resp.sendRedirect("/step04mvc2practice/index.html");
	}

}
