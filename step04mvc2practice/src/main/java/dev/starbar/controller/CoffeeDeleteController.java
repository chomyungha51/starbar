package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;

@WebServlet("/coffees/delete")
public class CoffeeDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("delId"));

		CoffeeDAO coffeeDAO = new CoffeeDAO();
		coffeeDAO.delete(id);
		resp.sendRedirect("/step04mvc2practice/index.html");
	}

}
