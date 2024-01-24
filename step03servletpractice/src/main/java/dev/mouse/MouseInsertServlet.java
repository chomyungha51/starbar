package dev.mouse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.dao.MouseDAO;
import dev.mouse.model.Mouse;


@WebServlet("/mice/add")
public class MouseInsertServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String country= req.getParameter("country");
		String address= req.getParameter("address");
		MouseDAO dao = new MouseDAO();
		dao.add(new Mouse(name, country, address));
		
		String path = "/mice";
		// /mice에서 새로고침했을 때 req의 요청 정보가 그대로 남아 있
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
//		resp.sendRedirect(path);
		
	}

}
