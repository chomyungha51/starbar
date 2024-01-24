package dev.syntax.step04querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/query-test-eng")
public class QueryServletEng extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GET");
		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String introduction = req.getParameter("introduction");
		
		System.out.printf("GET %s %s %s %s %s %s %s", id, pw, name, hobby, gender, country, introduction);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("id: " + id);
		out.println("pw: " + pw);
		out.println("name: " + name);
		out.println("hobby: " + hobby);
		out.println("gender: " + gender);
		out.println("country: " + country);
		out.println("introduction: " + introduction);
		

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String introduction = req.getParameter("introduction");
		System.out.printf("POST %s %s %s %s %s %s %s", id, pw, name, hobby, gender, country, introduction);

		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("id: " + id);
		out.println("pw: " + pw);
		out.println("name: " + name);
		out.println("hobby: " + hobby);
		out.println("gender: " + gender);
		out.println("country: " + country);
		out.println("introduction: " + introduction);
		

		out.close();
	}

}
