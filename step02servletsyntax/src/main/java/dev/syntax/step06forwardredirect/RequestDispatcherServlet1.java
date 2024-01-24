
package dev.syntax.step06forwardredirect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class RequestDispatcherServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>Dispatcher Servlet 수행 결과</h3>");

		String name = req.getParameter("name");
		req.setAttribute("age", 5);

		// 원하는 로직을 처리
		RequestDispatcher rdp = req.getRequestDispatcher("/page2");
		rdp.forward(req, resp);

		out.close();
	}
}