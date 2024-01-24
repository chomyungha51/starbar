package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/practice-login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		boolean loginResult = DAO.login(id, pw);

		if (loginResult) {
			
			HttpSession session = req.getSession();
			if (session.isNew() || session.getAttribute("id") == null) {
				session.setAttribute("id", id);
			} else {
				
			}
			resp.sendRedirect("/step02servletsyntax/authenticated.html");
		} else {
			resp.sendRedirect("/step02servletsyntax/login.html");
		}

	}

}
