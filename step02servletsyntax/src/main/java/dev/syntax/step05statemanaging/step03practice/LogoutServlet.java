package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice-logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션 가져와서
		HttpSession session = req.getSession(false);

		resp.setContentType("text/html;charset=UTF-8");

		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			
		}else {
			
		}

		resp.sendRedirect("/step02servletsyntax/index.html");

	}

}
